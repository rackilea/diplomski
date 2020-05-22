LoadingCache<Key, Graph> graphs = CacheBuilder.newBuilder()
       .expireAfterWrite(1, TimeUnit.MINUTES)
       .build(
           new CacheLoader<Key, Graph>() {
             public Graph load(Key key) {
               return createExpensiveGraph(key);
             }
           });