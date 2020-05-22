public void reverse() {
    int half = size / 2;
    for (int i = 0; i < half; i++) {
        int j = size - 1 - i; // position of matching element at the other end
        T item = get(i); // T is the type of data stored in the list
        set(i, get(j));
        set(j, item);
    }
}