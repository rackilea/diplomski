private static long method2(Path file, long dummyUsage) throws IOException {

    final MappedByteBuffer buffer;
    try (FileChannel channel = FileChannel.open(file, StandardOpenOption.READ)) {
        buffer = channel.map(MapMode.READ_ONLY, 0L, Files.size(file));
    }
    for (int i = 0; i < 1000; i++) {
        dummyUsage += buffer.order(ByteOrder.LITTLE_ENDIAN).getInt(i * 10000);
        dummyUsage += buffer.order(ByteOrder.BIG_ENDIAN).getInt(i * 10000 + 4);
    }
    return dummyUsage;
}