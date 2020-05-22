for (int i = 0; i < buckets.size(); i++) {
     LinkedList<Integer> innerList = buckets.get(i);
     for (Iterator<Integer> iterator = innerList.iterator(); iterator.hasNext();) {
        sorted.add(iterator.next());
        iterator.remove(); // this guy is optional
     }
  }