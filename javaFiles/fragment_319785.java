private static BufferedImage createCopyUsingByteBuffer(int w, int h, byte[] rawBytes) {
    short[] rawShorts = new short[rawBytes.length / 2];

    ByteBuffer.wrap(rawBytes)
            // .order(ByteOrder.LITTLE_ENDIAN) // Depending on the data's endianness
            .asShortBuffer()
            .get(rawShorts);

    DataBuffer dataBuffer = new DataBufferUShort(rawShorts, rawShorts.length);
    int stride = 1;
    WritableRaster raster = Raster.createInterleavedRaster(dataBuffer, w, h, w * stride, stride, new int[] {0}, null);
    ColorModel colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_GRAY), false, false, Transparency.OPAQUE, DataBuffer.TYPE_USHORT);

    return new BufferedImage(colorModel, raster, colorModel.isAlphaPremultiplied(), null);
}