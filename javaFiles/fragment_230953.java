public static void removeNthLine(String f, int toRemove) throws IOException {
    RandomAccessFile raf = new RandomAccessFile(f, "rw");

    // Leave the n first lines unchanged.
    for (int i = 0; i < toRemove; i++)
        raf.readLine();

    // Shift remaining lines upwards.
    long writePos = raf.getFilePointer();
    raf.readLine();
    long readPos = raf.getFilePointer();

    byte[] buf = new byte[1024];
    int n;
    while (-1 != (n = raf.read(buf))) {
        raf.seek(writePos);
        raf.write(buf, 0, n);
        readPos += n;
        writePos += n;
        raf.seek(readPos);
    }

    raf.setLength(writePos);
    raf.close();
}