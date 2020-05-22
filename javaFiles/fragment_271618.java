Map<String, List<String>> data = new HashMap<String, List<String>>();

void addValue(String key, String value) {
  if (!data.contains(key)) {
    data.put(key, new LinkedList());
  }
  data.get(key).add(value);
}