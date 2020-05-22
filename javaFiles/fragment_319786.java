private static BufferedImage createNoCopy(int w, int h, byte[] rawBytes) {
    DataBuffer dataBuffer = new DataBufferByte(rawBytes, rawBytes.length);

    int stride = 2;
    SampleModel sampleModel = new MyComponentSampleModel(w, h, stride);
    WritableRaster raster = Raster.createWritableRaster(sampleModel, dataBuffer, null);

    ColorModel colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_GRAY), false, false, Transparency.OPAQUE, DataBuffer.TYPE_USHORT);

    return new BufferedImage(colorModel, raster, colorModel.isAlphaPremultiplied(), null);
}

private static class MyComponentSampleModel extends ComponentSampleModel {
    public MyComponentSampleModel(int w, int h, int stride) {
        super(DataBuffer.TYPE_USHORT, w, h, stride, w * stride, new int[] {0});
    }

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
            sdata[i] = (short) (data.getElem(0, pixelOffset) << 8 | data.getElem(0, pixelOffset + 1));
            // If little endian, swap the element order, like this:
//            sdata[i] = (short) (data.getElem(0, pixelOffset + 1) << 8 | data.getElem(0, pixelOffset));
        }

        return sdata;
    }
}