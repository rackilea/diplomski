public void writeToFileNIOWay2(File file) throws IOException {
    final int numberOfIterations = 1000000;
    final String messageToWrite = "This is a test üüüüüüööööö";
    final byte[] messageBytes = messageToWrite.
            getBytes(Charset.forName("ISO-8859-1"));
    final long appendSize = numberOfIterations * messageBytes.length;
    final RandomAccessFile raf = new RandomAccessFile(file, "rw");
    raf.seek(raf.length());
    final FileChannel fc = raf.getChannel();
    final MappedByteBuffer mbf = fc.map(FileChannel.MapMode.READ_WRITE, fc.
            position(), appendSize);
    fc.close();
    for (int i = 1; i < numberOfIterations; i++) {
        mbf.put(messageBytes);
    }
}