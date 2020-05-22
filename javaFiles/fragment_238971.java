Integer[] getValuesByKey(Map<Pair<String,Integer>, Integer> map, String key) {
      return map.entrySet()
                .stream()
                .filter(e -> e.getKey().getKey().equals(key))
                .map(Map.Entry::getValue)
                .toArray(Integer[]::new);
}