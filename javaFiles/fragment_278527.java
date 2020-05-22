private void storeEquivalence(final Integer label0, final Integer label1, final Map<Integer, Integer> table) {
  if (table.keySet().contains(label0)) {
    table.put(label1, table.get(label0));
  }
  else if (table.keySet().contains(label1)) {
    table.put(label0, table.get(label1));
  }
  else {
    table.put(label0, label1);
  }
}