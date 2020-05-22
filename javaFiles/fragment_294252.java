File file = new File(fileName);
FileChannel channel = new RandomAccessFile(file, "rw").getChannel();

FileLock lock = channel.lock();
try {
    lock = channel.tryLock();
    System.out.print("file is not locked");
} catch (OverlappingFileLockException e) {
    System.out.print("file is locked");
} finally {
    lock.release();
}