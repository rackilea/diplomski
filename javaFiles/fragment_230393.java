List<String> keys = new ArrayList<>(map.size());
List<String> values = new ArrayList<>(map.size());
for(Map.Entry<String, String> entry: map.entrySet()) {
   keys.add(entry.getKey());
   values.add(entry.getValue());
}