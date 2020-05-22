final Iterator<int[]> iterator = outlets.iterator();
while (iterator.hasNext()) {
    final int[] item = iterator.next();
    ....
    if (...) {
        iterator.remove();
    }
}