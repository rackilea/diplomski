Map<String, Pair<Double, Integer>> result = map.entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(e -> e.getValue().getKey()))
                .collect(toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (l, r) -> l,
                        LinkedHashMap::new));