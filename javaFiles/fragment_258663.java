Queue<String> q = map.get(key);
if(q == null) {
  q = new ConcurrentLinkedQueue<String>();
  Queue<String> curQ = map.putIfAbsent(key, q);
  if(curQ != null) {
    q = curQ;
  }
}
q.add(value);