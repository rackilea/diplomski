public void increaseSizeOfArray(int incrementSize) {
    if (incrementSize > 0 && data != null && data.length > 0) {
        int copiedArray[] = Arrays.copyOf(data, data.length + incrementSize);
        data = copiedArray;
    }
}