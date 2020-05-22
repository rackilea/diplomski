Map<Integer, Integer> innerMap = typeIdCounts.get(type);
if (innerMap == null) {
    innerMap = new HashMap<>();
    typeIdCounts.put(product, innerMap);
}
innerMap.put(typeId, count);