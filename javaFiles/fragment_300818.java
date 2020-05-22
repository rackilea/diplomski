public void addToSet(String setName, String value) {
  if (!sets.containsKey(setName)) {
    sets.put(setName, new HashSet<String>());
  }
  Set<String> values = sets.get(setName);
  values.add(value);
}