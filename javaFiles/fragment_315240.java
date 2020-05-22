import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import com.google.common.collect.Sets;

public class EhCacheMapAdapter<K,V> implements Map<K,V> {
    @SuppressWarnings("unused")
    private final static Logger logger = Logger
            .getLogger(EhCacheMapAdapter.class);

    public Cache ehCache;

    public EhCacheMapAdapter(Cache ehCache) {
        super();
        this.ehCache = ehCache;
    } // end constructor

    @Override
    public void clear() {
        ehCache.removeAll();
    } // end method

    @Override
    public boolean containsKey(Object key) {
        return ehCache.isKeyInCache(key);
    } // end method

    @Override
    public boolean containsValue(Object value) {
        return ehCache.isValueInCache(value);
    } // end method

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    } // end method

    @SuppressWarnings("unchecked")
    @Override
    public V get(Object key) {
        if( key == null ) return null;
        Element element = ehCache.get(key);
        if( element == null ) return null;
        return (V)element.getObjectValue();
    } // end method

    @Override
    public boolean isEmpty() {
        return ehCache.getSize() == 0;
    } // end method

    @SuppressWarnings("unchecked")
    @Override
    public Set<K> keySet() {
        List<K> l = ehCache.getKeys();
        return Sets.newHashSet(l);
    } // end method

    @SuppressWarnings("unchecked")
    @Override
    public V put(K key, V value) {
        Object o = this.get(key);
        if( o != null ) return (V)o;
        Element e = new Element(key,value);
        ehCache.put(e);
        return null;
    } // end method


    @Override
    public V remove(Object key) {
        V retObj = null;
        if( this.containsKey(key) ) {
            retObj = this.get(key);
        } // end if
        ehCache.remove(key);
        return retObj;
    } // end method

    @Override
    public int size() {
        return ehCache.getSize();
    } // end method

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    } // end method

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for( K key : m.keySet() ) {
            this.put(key, m.get(key));
        } // end for
    } // end method
} // end class