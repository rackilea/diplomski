Map<Y,Map<X,Z>> out =
      originalMap.entrySet()
                 .stream()
                 .flatMap(e -> e.getValue()
                                .entrySet()
                                .stream()
                                .map(e2 -> {
                                    Map<X,Z> m = new HashMap<>();
                                    m.put(e.getKey(),e2.getValue());
                                    return new SimpleEntry<>(e2.getKey(),m);}))
                 .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(v1,v2)->{v1.putAll(v2);return v1;}));