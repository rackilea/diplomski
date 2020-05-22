public MyType retrieveItemByIndex(Iterable<MyType> iterable, int index) {

    if (iterable == null || index < 0) {

        return null;
    }

    int cursor = 0;

    Iterator<MyType> iterator = iterable.iterator();

    while (cursor < index && iterator.hasNext()) {

        iterator.next();
        cursor++;
    }

    return cursor == index && iterator.hasNext() ? iterator.next() : null;
}