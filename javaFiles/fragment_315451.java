import java.util.Collection;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;


public class InfinispanCache<K, V> implements Cache<K, V> {


    private final org.infinispan.Cache<K, V> cacheProxy;

    public InfinispanCache(final org.infinispan.Cache<K, V> cacheProxy) {
        this.cacheProxy = cacheProxy;
    }


    @Override
    public V get(final K key) throws CacheException {
        return cacheProxy.get(key);
    }


    @Override
    public V put(final K key, final V value) throws CacheException {
        return cacheProxy.put(key, value);
    }


    @Override
    public V remove(final K key) throws CacheException {
        return cacheProxy.remove(key);
    }


    @Override
    public void clear() throws CacheException {
        cacheProxy.clear();
    }


    @Override
    public int size() {
        return cacheProxy.size();
    }


    @Override
    public Set<K> keys() {
        return cacheProxy.keySet();
    }


    @Override
    public Collection<V> values() {
        return cacheProxy.values();
    }

}