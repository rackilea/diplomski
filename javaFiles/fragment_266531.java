Map<String,Integer> themap = 
       IntStream.range (0, keys.length).boxed()
                .collect (Collectors.toMap(i->keys[i],
                                           i->values[i],
                                           Integer::sum,
                                           TreeMap::new));