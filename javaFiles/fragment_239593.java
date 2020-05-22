Map<String, List<String>> group1 =
    bikes.entrySet()
         .stream().flatMap(e->e.getValue()
                               .stream()
                               .map(v->new SimpleEntry<String,String>(v,e.getKey())))
         .collect(Collectors.groupingBy(Map.Entry::getKey, 
                                        Collectors.mapping(Map.Entry::getValue,
                                                           Collectors.toList())));