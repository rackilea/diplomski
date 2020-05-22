m1sorted = m1.entrySet()
             .stream()
             .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
             .collect(Collectors.toMap(
               Map.Entry::getKey,
               Map.Entry::getValue,
               (e1, e2) -> e1,
               LinkedHashMap::new
             ));