LinkedHashMap<String, Object> finalMap = 
    Stream.concat(m1.entrySet().stream(), m2.entrySet().stream())
          .collect(Collectors.toMap(entry -> entry.getKey(),
                                    entry -> entry.getValue(),
                                    (v1, v2) -> v2,
                                    LinkedHashMap::new));