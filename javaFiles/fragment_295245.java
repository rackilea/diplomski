import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.CompositeMap;
import org.apache.commons.collections.map.CompositeMap.MapMutator;

public class MultiScopeModelMap extends CompositeMap implements Serializable, MapMutator
{
    public MultiScopeModelMap(int num)
    {
        super();
        setMutator( this );
        for(int i = 0; i < num; ++i)
        {
            addComposited( new HashMap() );
        }
    }

    /** Shadows composite map. */
    private final LinkedList<Map> maps = new LinkedList<Map>();

    @Override
    public synchronized void addComposited( Map map ) throws IllegalArgumentException
    {
        super.addComposited( map );
        this.maps.addLast( map );
    }



    @Override
    public synchronized Map removeComposited( Map map )
    {
        Map removed = super.removeComposited( map );
        this.maps.remove( map );
        return removed;
    }



    /** 
     * Starts a new scope. 
     * All items added in the session before the previous session are removed.
     * All items added in the previous scope are still retrievable and removable.
     */ 
    public void next()
    {
        removeComposited( this.maps.getFirst() );
        addComposited( new HashMap() );
    }

    public Object put( CompositeMap map, Map[] composited, Object key, Object value )
    {
        if(composited.length < 1)
        {
            throw new UnsupportedOperationException("No composites to add elements to");
        }
        Object result = map.get( key );
        if(result != null)
        {
            map.remove( key );
        }
        composited[composited.length-1].put( key, value );
        return result;
    }

    public void putAll( CompositeMap map, Map[] composited, Map mapToAdd )
    {
        for(Entry entry: (Set<Entry>)mapToAdd.entrySet())
        {
            put(map, composited, entry.getKey(), entry.getValue());
        }
    }

    public void resolveCollision( CompositeMap composite, Map existing, Map added, Collection intersect )
    {
        existing.keySet().removeAll( intersect );       
    }

    @Override
    public String toString()
    {
        return new HashMap(this).toString();
    }


}