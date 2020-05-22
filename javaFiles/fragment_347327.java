public E next() {
    if (!hasNext())
        throw new NoSuchElementException();

    DBObject dbObject = cursor.next();
    return resultHandler.map(dbObject);
}