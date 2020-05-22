public boolean equals(Bitmap bitmap1, Bitmap bitmap2) {
    ByteBuffer buffer1 = ByteBuffer.allocate(bitmap1.getHeight() * bitmap1.getRowBytes());
    bitmap1.copyPixelsToBuffer(buffer1);

    ByteBuffer buffer2 = ByteBuffer.allocate(bitmap2.getHeight() * bitmap2.getRowBytes());
    bitmap2.copyPixelsToBuffer(buffer2);

    return Arrays.equals(buffer1.array(), buffer2.array());
}