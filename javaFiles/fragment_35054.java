Map<Integer,String> mapA = new HashMap<>();
    mapA.put(1, "a");
    mapA.put(2, "b");
    mapA.put(3, "c");
    Map<Integer,String> mapB = new HashMap<>();
    mapB.put(5, "a");
    mapB.put(6, "d");
    mapB.put(7, "c");

    List<Integer> list = mapB.entrySet().stream()
                             .filter(e->mapA.containsValue(e.getValue()))
                             .map(e -> e.getKey())
                             .collect(Collectors.toList());
    System.out.println(list);