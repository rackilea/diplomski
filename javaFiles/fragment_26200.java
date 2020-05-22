LoadingCache<Key, Graph> graphs = CacheBuilder.newBuilder()
    .maximumSize(10000)
    .expireAfterWrite(10, TimeUnit.MINUTES)
    .build(
        new CacheLoader<Key, Graph>() {
          public Graph load(Key key) throws AnyException {
            return createExpensiveGraph(key);
          }
        });