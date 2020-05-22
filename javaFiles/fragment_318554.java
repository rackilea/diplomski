private void checkRange(final String operation, int start, int end) {
    if (end < start) {
        throw new IndexOutOfBoundsException(operation + " " +
                region(start, end) + " has end before start");
    }

    int len = length();

    if (start > len || end > len) {
        throw new IndexOutOfBoundsException(operation + " " +
                region(start, end) + " ends beyond length " + len);
    }

    if (start < 0 || end < 0) {
        throw new IndexOutOfBoundsException(operation + " " +
                region(start, end) + " starts before 0");
    }
}