int write(FileOutputStream fout) throws IOException {
            int bytes;
            FileChannel fChan = fout.getChannel();
        ByteBuffer str = ByteBuffer.wrap(magic.getBytes());
        bytes = fChan.write(str);

        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.order(ByteOrder.LITTLE_ENDIAN);

        buf.putInt(header_size);
        buf.rewind();
        bytes  += fChan.write(buf);
        buf.clear();
        ...

        return bytes;
   }

int read(FileInputStream fIn)  throws IOException {
    int bytes = 0;
    FileChannel fChan = fIn.getChannel();

    ByteBuffer buf = ByteBuffer.allocate(4);
    buf.order(ByteOrder.LITTLE_ENDIAN);

    bytes = fChan.read(buf);
    buf.rewind();
    magic = new String(buf.array());
    buf.clear();

    ...

    return bytes;
}