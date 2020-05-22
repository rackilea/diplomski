PriorityQueue<DataObject> top = new PriorityQueue(10, comparator);
for (DataObject item : items) {
  if (top.size() < 10) top.add(item);
  else if(comparator.compare(top.peek(), item) < 0) {
    top.remove();
    top.add(item);
  }
}