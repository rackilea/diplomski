private static final Map<String, Long> NUMBER_MAP;
static {
  final Map<String, Long> map = new HashMap<String, Long>();
  map.put("one", 1L);
  map.put("two", 2L);
  map.put("three", 3L);
  ...
  map.put("hundred", 100L);
  map.put("hundreds", 100L);
  ...
  map.put("billion", 1000000000L);
  map.put("billions", 1000000000L);
  NUMBER_MAP = Collections.unmodifiableMap(map);
}