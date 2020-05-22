static List<String> getListOfValuesByItemNumber(
            Map<String, Collection<Map<String, String>>> map,
                                                     String itemNumber){
         List<String> accumulator = new ArrayList<>();
              map.values()
                 .forEach(collection -> 
                         collection.forEach(m -> m.forEach((k, v) -> {
                             if(k.equals(itemNumber))
                                 accumulator.add(v);
                         })));
         return accumulator;
}