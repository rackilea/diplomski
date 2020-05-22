Map<Integer, String> map = ...

Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();

while (it.hasNext()) {
  Map.Entry<Integer, String> entry = it.next();

  // Remove entry if key is null or equals 0.
  if (entry.getKey() == null || entry.getKey() == 0) {
    it.remove();
  }
}