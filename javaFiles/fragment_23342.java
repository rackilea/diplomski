int w = 2;
int h = 2;
int stride = 1;

byte[] rawBytes = {0x21, 0x27, 0x33, (byte) 0xF6, 0x28, (byte) 0xF3, (byte) 0x27, (byte) 0xF2};
short[] rawShorts = new short[rawBytes.length / 2];

ByteBuffer.wrap(rawBytes)
        .order(ByteOrder.LITTLE_ENDIAN)
        .asShortBuffer()
        .get(rawShorts);

DataBuffer dataBuffer = new DataBufferUShort(rawShorts, rawShorts.length);
WritableRaster raster = Raster.createInterleavedRaster(dataBuffer, w, h, w * stride, stride, new int[]{0}, null);
ColorModel colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_GRAY), false, false, Transparency.OPAQUE, DataBuffer.TYPE_USHORT);

BufferedImage image = new BufferedImage(colorModel, raster, colorModel.isAlphaPremultiplied(), null);