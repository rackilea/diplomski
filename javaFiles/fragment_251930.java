public LString replace(int start,   int end, LString lStr) {
    if (start < 0 || end > length() || start > end) {
     throw new IndexOutOfBoundsException();
    }

    if (this.front == null) {
       return lStr; // maybe correct logic for you?
    }