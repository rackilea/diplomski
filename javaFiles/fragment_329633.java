package com.mine;

import java.io.Serializable;

import junit.framework.TestCase;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.TerracottaClientConfiguration;
import net.sf.ehcache.config.TerracottaConfiguration;

public class CacheEvictionTest extends TestCase {

    private static final String SERVER = "localhost:9510";
    private CacheManager cacheManager;
    private Cache cache;
    private final Serializable keyA = "a";
    private final Serializable keyB = "b";
    private final Serializable keyC = "c";

    @Override
    protected void setUp() throws Exception {
        Configuration configuration = new Configuration();
        TerracottaClientConfiguration terracottaConfig = new TerracottaClientConfiguration();
        terracottaConfig.setUrl(SERVER);
        configuration.addTerracottaConfig(terracottaConfig);

        int maxElementsInMemory = 1;
        int maxElementsOnDisk = 2;
        long timeToIdleSeconds = 15;
        long timeToLiveSeconds = 15;
        String cacheName = "TEST_CACHE";
        CacheConfiguration amoebaCache = new CacheConfiguration(cacheName, maxElementsInMemory).statistics(true)
                        .terracotta(new TerracottaConfiguration())
                        .logging(true)
                        .maxElementsOnDisk(maxElementsOnDisk)
                        .timeToIdleSeconds(timeToIdleSeconds)
                        .timeToLiveSeconds(timeToLiveSeconds);
        configuration.addCache(amoebaCache);
        configuration.addDefaultCache(new CacheConfiguration("default", 0));

        cacheManager = new CacheManager(configuration);
        cache = cacheManager.getCache(cacheName);
    }

    @Override
    protected void tearDown() throws Exception {
        if (cache != null) {
            cache.removeAll();
            cache.clearStatistics();
        }
    }

    public void testMaxElementOnDiskEvictionJVM1() throws Exception {
        cache.clearStatistics();

        cache.put(new Element(keyA, keyA));
        cache.put(new Element(keyB, keyB));

        cache = null;
    }

    public void testMaxElementOnDiskEvictionJVM2() throws Exception {
        assertEquals(2, cache.getSize());

        for (Object key : cache.getKeys()) {
            cache.get(key;
        }

        cache.put(new Element(keyC, keyC));

        assertEquals(2, cache.getSize());
        assertNotNull(cache.get(keyC));
    }

    public void testEvictsExpiredElementsFromDiskWhenNotInMemoryAndWeNeverKnewAboutItJVM1() throws Exception {
        cache.clearStatistics();
        cache.put(new Element(keyA, keyA));

        cache = null;
        cacheManager = null;
    }

    public void testEvictsExpiredElementsFromDiskWhenNotInMemoryAndWeNeverKnewAboutItJVM2() throws Exception {
        cache.clearStatistics();

        for (Object key : cache.getKeys()) {
            cache.get(key;
        }
        assertEquals(0, cache.getStatistics().getEvictionCount());

        Thread.sleep(20000);

        assertEquals(1, cache.getStatistics().getEvictionCount());
    }
}