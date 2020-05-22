final List<Integer> list = Arrays.asList(new Integer[]{1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5});
  final Map<Integer, Integer> cardinalityMap = CollectionUtils.getCardinalityMap(list);
  final int minCardinality = Collections.min(cardinalityMap.values());
  System.out.println("min cardinality: " + minCardinality);
  for (final Map.Entry<Integer, Integer> entry: cardinalityMap.entrySet()) {
    if (minCardinality == entry.getValue()) {
      System.out.println("key: " + entry.getKey());
    }
  }