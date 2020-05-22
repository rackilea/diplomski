RandomAccessFile raf = new RandomAccessFile("input.mp3", "rw");
byte[] buf = new byte[65536];
long pos = 0;
int len;
Random random = new Random(34);
while ((len = raf.read(buf)) != -1) {
    for (int i = 0; i < len; i++) {
        buf[i] ^= random.nextInt();
    }
    raf.seek(pos);
    raf.write(buf);
    pos = raf.getFilePointer();
}
raf.close();