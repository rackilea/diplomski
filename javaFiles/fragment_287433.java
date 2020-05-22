long realSize;

if (myList.size() < Integer.MAX_VALUE) {
    realSize = myList.size();
} else {
    realSize = Integer.MAX_VALUE;
    ListIterator<Foo> iter = myList.listIterator(Integer.MAX_VALUE);
    while (iter.hasNext()) {
      realSize++;
      iter.next();
    }
 }