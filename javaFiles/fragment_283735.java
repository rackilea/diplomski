private static long method3(Path file, long dummyUsage) throws IOException {

    try (RandomAccessFile raf = new RandomAccessFile(file.toFile(), "r")) {
        for (int i = 0; i < 1000; i++) {

            raf.seek(i * 10000);
            dummyUsage += Integer.reverseBytes(raf.readInt());
            raf.seek(i * 10000 + 4);
            dummyUsage += raf.readInt();
        }
    }
    return dummyUsage;
}