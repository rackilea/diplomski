List<long[]> longArrays = arrays.stream().map(byteArray -> {
    long[] longArray = new long[4096 / 8];
    ByteBuffer.wrap(byteArray).asLongBuffer().get(longArray);
    return longArray;
}).collect(Collectors.toList());
longArrays.forEach(this::byteArrayCheck8);
benchmark(longArrays, this::byteArrayCheck8, "byteArrayCheck8");

List<int[]> intArrays = arrays.stream().map(byteArray -> {
    int[] intArray = new int[4096 / 4];
    ByteBuffer.wrap(byteArray).asIntBuffer().get(intArray);
    return intArray;
}).collect(Collectors.toList());
intArrays.forEach(this::byteArrayCheck9);
benchmark(intArrays, this::byteArrayCheck9, "byteArrayCheck9");

private boolean byteArrayCheck8(final long[] array) {
    for (long l : array) {
        if (l != 0) {
            return false;
        }
    }
    return true;
}

private boolean byteArrayCheck9(final int[] array) {
    for (int i : array) {
        if (i != 0) {
            return false;
        }
    }
    return true;
}