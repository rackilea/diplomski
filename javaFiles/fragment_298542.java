Integer count = counts.get(key);
if (count == null) {
  count = 0;
}
count++;
counts.put(key, count);