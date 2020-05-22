private final Map<String, String> pool = new HashMap<String, String>();

private void interned(String s) {
  String interned = pool.get(s);
  if (interned != null) {
    return interned;
  pool.put(s, s);
  return s;
}

private void readFile(CsvFile csvFile) {
  for (List<String> row : csvFile) {
    for (int i = 0; i < row.size(); i++) {
      row.set(i, interned(row.get(i)));
      // further process the row
    }
  }
  pool.clear(); // allow the garbage collector to clean up
}