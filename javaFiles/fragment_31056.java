Map<String, Integer> m1s =
        m1.entrySet()
          .stream()
          .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
          .collect(Collectors.toMap(Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new));

Map<String, String> m2s =
        m2.entrySet()
          .stream()
          .sorted((e1, e2) -> Integer.compare(m1.get(e2.getKey()), m1.get(e1.getKey())))
          .collect(Collectors.toMap(Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new));

Map<String, Double> m3s =
        m3.entrySet()
          .stream()
          .sorted((e1, e2) -> Integer.compare(m1.get(e2.getKey()), m1.get(e1.getKey())))
          .collect(Collectors.toMap(Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new));