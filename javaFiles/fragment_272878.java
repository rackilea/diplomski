Iterator<A> itA = listA.iterator();
Iterator<B> itB = listB.iterator();
while (itA.hasNext() && itB.hasNext()) {
    A nextA = itA.next();
    B nextB = itB.next();
    // ...do something with them...
}