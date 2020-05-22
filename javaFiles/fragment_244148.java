List<String> keyList = new ArrayList<String>(map.keySet());
for(int i = fromIndex; i < toIndex; i++) {
    String key = keyList.get(i);
    String value = map.get(key);
    ...
}