public Integer find(String searchedKey, List<String> keys, List<Integer> values) {
  for (int i = 0; i < keys.size() && i < values.size(); i++) {
    if (searchedKey.equals(keys.get(i))) {
      return values.get(i);
    }
  }
  return null;
}