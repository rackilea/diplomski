//build the cacheconfig. this part belongs to httpclient
CacheConfig cacheConfig = CacheConfig
     .custom()
     .setMaxCacheEntries(1000)
     .setMaxObjectSize(8192)
     .build();