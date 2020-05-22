Map<Y,Map<X,Z>> out =
      originalMap.entrySet()
                 .stream()
                 .flatMap(e -> e.getValue()
                                .entrySet()
                                .stream()
                                .map(e2 -> new SimpleEntry<>(e2.getKey(),Map.of(e.getKey(),e2.getValue()))))
                 .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(v1,v2)->{v1.putAll(v2);return v1;}));