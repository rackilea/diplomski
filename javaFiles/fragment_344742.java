ConcurrentMap<String, PreparedStatement> cache = new MapMaker()
       .concurrencyLevel(32)
       .weakValues()
       .makeComputingMap(
           new Function<String, PreparedStatement>() {
             public PreparedStatement apply(String cql) {
               return createPreparedStatement(cql);
             }
           });