public static <T> T retrieveItemByIndex(Iterable<T> iterable, int index) {

    if (iterable == null || index < 0) {

        return null;
    }

    int cursor = 0;

    Iterator<T> iterator = iterable.iterator();

    while (cursor < index && iterator.hasNext()) {

        iterator.next();
        cursor++;
    }

    return cursor == index && iterator.hasNext() ? iterator.next() : null;
}