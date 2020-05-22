DataBufferInt buffer = new DataBufferInt(pixels, pixels.length);

int[] bandMasks = {0xFF0000, 0xFF00, 0xFF}; // RGB (no alpha)
WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, bandMasks, null);

ColorModel cm = new DirectColorModel(32,
        0x00ff0000,       // Red
        0x0000ff00,       // Green
        0x000000ff,       // Blue
        0x00000000        // No Alpha
);
BufferedImage bufferImg = new BufferedImage(cm, raster, cm.isAlphaPremultiplied(), null);