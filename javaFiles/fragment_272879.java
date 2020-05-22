Iterator<A> itA = listA.iterator();
for (B nextB : listB) {
    if (!itA.hasNext()) {
        break;
    }
    A nextA = itA.next();
    // ...do something with them...
}