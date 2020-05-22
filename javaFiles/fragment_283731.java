private static long method1(Path file, long dummyUsage) throws IOException, Error {
    try (FileChannel channel = FileChannel.open(file, StandardOpenOption.READ)) {

        for (int i = 0; i < 1000; i++) {
            ByteBuffer dst = ByteBuffer.allocate(8);

            if (channel.position(i * 10000).read(dst) != dst.capacity())
                throw new Error("partial read");
            dst.flip();
            dummyUsage += dst.order(ByteOrder.LITTLE_ENDIAN).getInt();
            dummyUsage += dst.order(ByteOrder.BIG_ENDIAN).getInt();
        }
    }
    return dummyUsage;
}