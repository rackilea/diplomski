Iterator<E> iterator = array.iterator();
if (!iterator.hasNext()) {
    return 0;
}
E current = iterator.next();
while (iterator.hasNext()) {
    E next = iterator.next();
    // Do comparisons here
    current = next;
}