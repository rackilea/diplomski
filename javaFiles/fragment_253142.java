conversions.putAll(success);
// you haven't told us the key type, so I just use Key here
for (Map.Entry<Key, Integer> entry : failed.entrySet()) { 
  Key id = entry.getKey();
  Integer old = conversions.get(id);
  if (old != null) {
    conversions.put(id, old + entry.getValue());
  } else {
    conversions.put(id, entry.getValue());
  }
}