File tmpFile = new File(System.getProperty("java.io.tmpdir"), "lock-test.dat");
FileChannel fc = new RandomAccessFile(tmpFile, "rw").getChannel();
MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, RECORDS * RECORD_SIZE);
ByteBufferBytes bytes = new ByteBufferBytes(mbb.order(ByteOrder.nativeOrder()));


// the lock and toggle.
bytes.busyLockLong(recordOffset + LOCK);
try {
    boolean flag = bytes.readBoolean(recordOffset + FLAG);
    if (flag == toggleTo) {
        if (t % 100 == 0)
            System.out.println("j: " + j + " is " + flag);
        continue;
    }
    bytes.writeBoolean(recordOffset + FLAG, toggleTo);
    break;
} finally {
    bytes.unlockLong(recordOffset + LOCK);
}