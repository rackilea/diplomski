public void add(E item) {

    if (size == capacity) {
        reallocate();
    }

    theData[size++] = item;
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - 1; j++) {
            if (theData[j].compareTo(theData[j + 1]) > 0) {
                // perform the swap (you need an extra variable!
            }
        }
    }
}