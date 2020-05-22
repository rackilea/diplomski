Iterator<Integer> iterator = hmap.values().iterator();
while (iterator.hasNext()) {
  if (iterator.next() < threshold) {
     iterator.remove();
  }
}