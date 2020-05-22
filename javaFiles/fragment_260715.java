List<Map<Integer,Double>> list = new ArrayList<>();
List<Map<? extends Number,? extends Number>> listX = list;  // Doesn't work, pretend it does.

Map<Double,Integer> map = new HashMap<>();
map.put(0.0, 0);

listX.add(map);

for (Map<Integer, Double> e : list) {
  Integer i = e.keySet().iterator().next();  // ClassCastException!
}