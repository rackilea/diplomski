int index = 0;
for (Map.Entry<Key, Value> entry : map.entrySet()) {
  Key key = entry.getKey();
  Value value = entry.getValue();

  // Whatever code using (key, value, index)...

  ++index;
}