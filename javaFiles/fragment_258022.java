while (myQueue.size() >= THRESHOLD) {
  Element e = myQueue.poll();
  if (e != null) {
    process(e);
  }
}
myQueue.add(newElement);