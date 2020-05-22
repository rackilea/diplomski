Stream.of(new AbstractMap.SimpleEntry<MapKeyEnums, CompletableFuture<Set<String>>>(MapKeyEnums.ABC, first),
              new AbstractMap.SimpleEntry<MapKeyEnums, CompletableFuture<Set<String>>>(MapKeyEnums.XYZ, second),
              new AbstractMap.SimpleEntry<MapKeyEnums, CompletableFuture<Set<String>>>(MapKeyEnums.DEF, third))
       .forEach(entry->{
           entry.getValue().thenAccept(val-> instrumentsEdgesMap.put(entry.getKey(), val));
       });