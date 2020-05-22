public List<Pair<T>> getAllUndirectedPairsAsList(Set<T> setObjects) {
    List<T> listObjects = new ArrayList();
    listObjects.addAll(setObjects);

    List<Pair<T>> listPairs = new ArrayList();
    Iterator<T> listIterator1 = listObjects.listIterator();
    Iterator<T> listIterator2;
    int count = 1;
    T object1;
    while (listIterator1.hasNext()) {
        object1 = listIterator1.next();
        listIterator2 = listObjects.listIterator(count++);
        while (listIterator2.hasNext()) {
            listPairs.add(new Pair(object1, listIterator2.next()));
        }
    }
    return listPairs;
}