public class CaseInsensitiveForwardingMap<V> extends ForwardingMap<String, V>
    implements Serializable{

    private static final long serialVersionUID = -7741335486707072323L;

    // default constructor
    public CaseInsensitiveForwardingMap(){
        this(new HashMap<String, V>());
    }

    // constructor with a supplied map    
    public CaseInsensitiveForwardingMap(final Map<String, V> inner){
        this.inner = inner;
    }

    private final Map<String, V> inner;
    @Override
    protected Map<String, V> delegate(){
        return inner;
    }

    // convert keys to lower case Strings, preserve null keys
    private static String lower(final Object key){
        return key == null ? null : key.toString().toLowerCase();
    }

    @Override
    public V get(final Object key){ return inner.get(lower(key)); }
    @Override
    public void putAll(final Map<? extends String, ? extends V> map){
        if(map == null || map.isEmpty()){  inner.putAll(map); }
        else{
            for(final Entry<? extends String, ? extends V> entry :
                map.entrySet()){
                    inner.put(lower(entry.getKey()), entry.getValue());
            }
        }
    }
    @Override
    public V remove(final Object object){ return inner.remove(lower(object)); }
    @Override
    public boolean containsKey(final Object key){
        return inner.containsKey(lower(key));
    }
    @Override
    public V put(final String key, final V value){
        return inner.put(lower(key), value);
    }
}