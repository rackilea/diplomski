public String substring(int start) {
    if (start == 0) {
        return this;
    }
    if (start >= 0 && start <= count) {
        return new String(offset + start, count - start, value); // !!!
    }
    throw indexAndLength(start);
}