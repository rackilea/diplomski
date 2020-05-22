Map<Integer,Map<String,Double>> map = new HashMap<>();
Map<String,Double> map100 = new HashMap<>();
map100.put("a", 2.0);
map100.put("b", 1.0);
map100.put("c", 2.0);
Map<String,Double> map101 = new HashMap<>();
map101.put("a", 2.0);
map101.put("b", 1.0);
Map<String,Double> map102 = new HashMap<>();
map102.put("a", 2.0);
map102.put("b", 1.0);
map102.put("c", 2.0);
map102.put("d", 2.0);
map.put(100, map100);
map.put(101, map101);
map.put(102, map102);

System.out.println(map.keySet().stream().max(Comparator.comparingInt(v -> map.get(v).size())));

System.out.println(map.keySet().stream().max((v1, v2) -> {
    return Integer.compare(map.get(v1).size(), map.get(v2).size());
}));