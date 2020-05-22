byte[] pixelData = getPixels(convert(bitmap, Bitmap.Config.ALPHA_8));

...

 public byte[] getPixels(Bitmap bmp) {
    int bytes = bmp.getRowBytes() * bmp.getHeight();
    ByteBuffer buffer = ByteBuffer.allocate(bytes);
    bmp.copyPixelsToBuffer(buffer);
    return buffer.array();
}