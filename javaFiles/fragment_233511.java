public class YourConverter implements StdConverter<Map<Long, A>, Map<Long, String>> {
  @Override
  public Map<Long, String> convert(final Map<Long, A> inMap) {
    final HashMap<Long, String> outMap = new HashMap<>();
    inMap.forEach((k, v) -> outMap.put(k, v.getId()));
    return outMap;
    // Or as one-liner
    // return inMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getId()));
  }
}