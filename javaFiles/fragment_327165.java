LoadingCache<Key, Graph> graphs = CacheBuilder.newBuilder()
   .maximumSize(1000)
   .expireAfterWrite(10, TimeUnit.MINUTES)
   // ... other configuration builder methods ...
   .build(
       new CacheLoader<Key, Graph>() {
         public Graph load(Key key) throws AnyException {
           return createExpensiveGraph(key);
         }
       });