int w = 2, h = 2, stride = 2;
byte[] rawBytes = {0x21, 0x27, 0x33, (byte) 0xF6, 0x28, (byte) 0xF3, (byte) 0x27, (byte) 0xF2};
DataBuffer dataBuffer = new DataBufferByte(rawBytes, rawBytes.length);

SampleModel sampleModel = new ComponentSampleModel(DataBuffer.TYPE_USHORT, w, h, stride, w * stride, new int[] {0}) {
    @Override
    public Object getDataElements(int x, int y, Object obj, DataBuffer data) {
        if ((x < 0) || (y < 0) || (x >= width) || (y >= height)) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }

        // Simplified, as we only support TYPE_USHORT
        int numDataElems = getNumDataElements();
        int pixelOffset = y * scanlineStride + x * pixelStride;

        short[] sdata;

        if (obj == null) {
            sdata = new short[numDataElems];
        }
        else {
            sdata = (short[]) obj;
        }

        for (int i = 0; i < numDataElems; i++) {
            sdata[i] = (short) (data.getElem(bankIndices[i], pixelOffset + bandOffsets[i] + 1) << 8|
                    data.getElem(bankIndices[i], pixelOffset + bandOffsets[i]));
        }

        return sdata;
    }
};
ColorModel colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_GRAY), false, false, Transparency.OPAQUE, DataBuffer.TYPE_USHORT);
WritableRaster raster = Raster.createWritableRaster(sampleModel, dataBuffer, null);

BufferedImage image = new BufferedImage(colorModel, raster, colorModel.isAlphaPremultiplied(), null);