ConcurrentMap<Key, Graph> graphs = new MapMaker()
   .concurrencyLevel(4)
   .softKeys()
   .weakValues()
   .maximumSize(10000)
   .expiration(10, TimeUnit.MINUTES)
   .makeComputingMap(
       new Function<Key, Graph>() {
         public Graph apply(Key key) {
           return createExpensiveGraph(key);
         }
       });