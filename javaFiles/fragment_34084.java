BufferedImage img = create3ByteRGBImage(int width, int height, new int[] {8, 8, 8},
                                     new int[] {0, 1, 2});    

private BufferedImage create3ByteRGBImage(width, height, int[] nBits, int[] bOffs) {
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
            ColorModel colorModel =
                new ComponentColorModel(cs, nBits,
                                        false, false,
                                        Transparency.OPAQUE,
                                        DataBuffer.TYPE_BYTE);
            WritableRaster raster =
                Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE,
                                               width, height,
                                               width*3, 3,
                                               bOffs, null);
            return new BufferedImage(colorModel, raster, false, null);
        }