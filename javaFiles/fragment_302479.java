final String wholeString = " HausA HausB";
final Map<String, Set<String>> generateMap = new LinkedHashMap<String, Set<String>>();
final int windowSize = 5;

final int limit = wholeString.length() - windowSize;
for (int i = 0; i < limit; i++) {
  final int endKey = i + windowSize;
  final String
      first = wholeString.substring(i, endKey),
      second = wholeString.substring(endKey, endKey + 1);
  if (!generateMap.containsKey(first))
    generateMap.put(first, new HashSet<String>());
  generateMap.get(first).add(second);
}

for (Entry<String, Set<String>> e : generateMap.entrySet()) {
  System.out.println(e.getKey() + " -> " + e.getValue());
}