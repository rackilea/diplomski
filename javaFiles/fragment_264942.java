ListIterator<Object> iter = keys.listIterator(keys.size());
while (iter.hasPrevious()){
    Object prev=iter.previous();
    // do your Element creation here
    // then use the iter.add() method
    iter.add(/*new object*/);
}