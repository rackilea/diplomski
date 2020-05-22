ConcurrentMap<Key, Graph> graphs = new MapMaker()
   .concurrencyLevel(4)
   .weakKeys()
   .maximumSize(10000)
   .expireAfterWrite(10, TimeUnit.MINUTES)
   .makeComputingMap(
       new Function<Key, Graph>() {
         public Graph apply(Key key) {
           return createExpensiveGraph(key);
         }
       });