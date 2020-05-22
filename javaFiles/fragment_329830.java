private <T> int getObjectIndexFromList(List<T> list, Predicate<T> predicate){
    ListIterator<T> it = list.listIterator();
    while (it.hasNext()) {
        // Get the item and it's index in the list
        int index = it.nextIndex();
        T item = it.next();
        if (predicate.test(item)) {
            // We found it, return the index
            return index;
        }
    }
    // We didn't find anything
    return -1;
}