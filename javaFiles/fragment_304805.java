Map<String, List<String>> o = list.stream()
   .reduce(
        new TreeMap<String, List<String>>(),
        (map,j) -> {
            if (j.startsWith("src")) {
                map.putIfAbsent(j, new ArrayList<>());
            } else {
                map.get(map.lastKey()).add(j);
            }
            return map;},
        (i,j) -> i);