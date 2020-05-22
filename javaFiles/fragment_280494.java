Map<String, Integer> skMaxMap =  recordListBySK
    .entrySet()
    .stream()
    .collect(Collectors
                .toMap( e -> e.getKey(),
                        e -> e.getValue()
                              .stream()
                              .mapToInt(v -> Integer.parseInt(v.get("PR")))
                              .max()
                              .getAsInt() 
                      )
            );