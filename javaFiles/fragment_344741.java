LoadingCache<String, PreparedStatement> cache = CacheBuilder.newBuilder()
       .maximumSize(1000)
       .expireAfterWrite(10, TimeUnit.MINUTES)
       .build(
           new CacheLoader<String, PreparedStatement>() {
             public PreparedStatement load(String cql) throws Exception {
               return createPreparedStatement(cql);
             }
           });