private List<JsonObject> getExcessElements(List<JsonObject> primaryList, List<JsonObject> secondaryList, String primaryKey, String secondaryKey) {
List<JsonObject> excessInPrimary = primaryList.stream()
.filter(e -> (secondaryList.stream()
.filter(d -> d.get(secondaryKey).equals(e.get(primaryKey)))
.count()) < 1)
.collect(Collectors.toList());
return excessInPrimary;
}