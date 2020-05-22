for (int i = 0; i < buckets.size(); i++) {
     LinkedList<Integer> innerList = buckets.get(i);
     for (int j = 0; j < innerList.size(); j++) {
        sorted.add(innerList.poll());
     }
  }