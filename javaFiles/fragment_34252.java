synchronized (set) {
  set.add(value);
  if (set.size() > cap) {
    set.pollFirst();
  }
}