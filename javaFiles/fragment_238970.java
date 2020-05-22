int[] getValuesByKey(Map<Pair<String,Integer>, Integer> map, String key) {
      return map.entrySet()
                .stream()
                .filter(e -> e.getKey().getKey().equals(key))
                .mapToInt(Map.Entry::getValue)
                .toArray();
}