import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.infinispan.manager.CacheContainer;


public class InfinispanCacheManager implements CacheManager {


    private final CacheContainer cacheContainer;

    public InfinispanCacheManager(final CacheContainer cacheContainer) {
        this.cacheContainer = cacheContainer;
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public <K, V> Cache<K, V> getCache(final String name) throws CacheException {
        return new InfinispanCache(cacheContainer.getCache(name));
    }

}