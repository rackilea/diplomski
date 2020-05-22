import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.DiskStoreConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration.Strategy;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

import org.apache.http.impl.client.cache.CacheConfig;
import org.apache.http.impl.client.cache.CachingHttpClients;
import org.apache.http.impl.client.cache.ehcache.EhcacheHttpCacheStorage;


//build the cacheconfig. this part belongs to httpclient
CacheConfig cacheConfig = CacheConfig
     .custom()
     .setMaxCacheEntries(1000)
     .setMaxObjectSize(8192)
     .build();
//this part creates the ehcache 
//Create a singleton CacheManager using defaults
mgr = CacheManager.create();

//Create a Cache named http specifying its configuration.
Cache testCache = new Cache(new CacheConfiguration("http", 100000)
.memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU)
.eternal(false)
.timeToLiveSeconds(60)
.timeToIdleSeconds(30)
.diskExpiryThreadIntervalSeconds(0)
//Persist everything and keep it on restart
.persistence(new PersistenceConfiguration().strategy(Strategy.LOCALRESTARTABLE)));
mgr.addCache(testCache);
//get the cache back out the manager
Cache cache = mgr.getCache("http");

// and we are back to http-client
//Wrap it around EhcacheHttpCacheStorage which implements HttpCacheStorage
EhcacheHttpCacheStorage ehcacheHttpCacheStorage = new EhcacheHttpCacheStorage(cache);
//And Configure the httpclient
CloseableHttpClient httpclient = CachingHttpClients.custom()
   .setCacheConfig(cacheConfig)
   .setHttpCacheStorage(ehcacheHttpCacheStorage)
   .build();