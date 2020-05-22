public void B(byte[] bytes) {
    while (out.size() < bytes.length) {
        byte[] chunk = A();
        out.write(chunk, 0, chunk.length);
    }
    byte[] buffered = out.toByteArray();
    out.reset();
    System.arraycopy(buffered, 0, bytes, 0, bytes.length);
    out.write(buffered, bytes.length, buffered.length - bytes.length);
}