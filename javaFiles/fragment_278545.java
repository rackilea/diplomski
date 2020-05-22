ConcurrentMap<Key,Value> map = ...

Value computeIfAbsent(Key k) {
  Value v = map.get(k);
  if (v == null) {
    Value vNew = new Value(...); // or whatever else you do to compute the value
    v = (v = map.putIfAbsent(k, vNew)) == null ? vNew : v;
  }
  return v;
}