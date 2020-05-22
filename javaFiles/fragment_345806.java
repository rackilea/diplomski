public int indexOf( char ch ) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == ch) {
            return i;   // Character found, return current index
        }
    }
    return -1;    // Character not found. Return -1
}