public void add(T x) {
    if (size >= collection.length)
        throw new IllegalStateException();
    collection[size] = x;
    ++size;
}