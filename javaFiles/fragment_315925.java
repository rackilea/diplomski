@Test
public void testManualInsertion() {

    Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .removalListener(new MyRemovalListener())
            .concurrencyLevel(4)
            .recordStats()
            .build();


    cache.put("someKey", "someValue");

    assertEquals("someValue", cache.getIfPresent("someKey"));

}