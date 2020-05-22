private static final ComponentColorModel colormodel =
    new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB),
                            new int[] {8, 8, 8, 8}, true, false,
                            ComponentColorModel.TRANSLUCENT, DataBuffer.TYPE_BYTE);
public static BufferedImage makeimage(int w, int h) {
    WritableRaster buf = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE, w, h, 4, null);
    return(new BufferedImage(colormodel, buf, false, null));
}