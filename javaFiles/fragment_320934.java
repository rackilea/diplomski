Object lock;
synchronized (locks) {
  if (locks.containsKey(key))
    lock = locks.get(key);
  else {
    lock = new Object();
    locks.put(key, object);
  }
}