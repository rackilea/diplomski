LoadingCache<Integer, String> cache = CacheBuilder.newBuilder()
   .maximumSize(100)
   .expireAfterWrite(10, TimeUnit.MINUTES)
   .build(
       new CacheLoader<Integer, String>() {
           @Override
           public String load(Integer id) throws Exception {
               return "value";
           }
       }
   );