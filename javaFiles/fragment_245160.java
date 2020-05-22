Map<Double,Integer> map = new HashMap<>();
map.put(0.7, 100);
map.put(0.5, 200);

double weightedAverage =
  map.entrySet().stream().collect(averagingWeighted(Map.Entry::getKey, Map.Entry::getValue));