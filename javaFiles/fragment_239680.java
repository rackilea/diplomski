private void writeoutFromPNGFile(int width, int numBands, int minY, int height,         RenderedImage im, int minX) throws IOException {
    System.out.println("Writing from PNG data.");
    //convertTo2DWithoutUsingGetRGB(im);
    //now start writing the file...
    int[] pixels = new int[8 * width * numBands];

    int count = 0;

    // Process 8 rows at a time so all but the last will have
    // a multiple of 8 pixels.  This simplifies PBM_RAW encoding.
    int lastRow = minY + height;
    for (int row = minY; row < lastRow; row += 8) {
        int rows = Math.min(8, lastRow - row);
        int size = rows * width * numBands;

        // Grab the pixels
        Raster src = im.getData(new Rectangle(minX, row, width, rows));
        src.getPixels(minX, row, width, rows, pixels);

        for (int i = 0; i < size; i += 4) {
            //output.write(pixels[i] & 0xFF);
            int red = pixels[i];
            int green = pixels[i + 1];
            int blue = pixels[i + 2];
            int alpha = pixels[i + 3];
            //System.out.println("Pixel Value: " + o);
            convertTo5551(red, green, blue, alpha);
        }

    }
}


int convertTo5551(int r, int g, int b, int a) throws IOException {
    int r5 = r * 31 / 255;
    int g5 = (int) g * 31 / 255;
    int b5 = (int) b * 31 / 255;
    int a1 = (a > 0) ? 0 : -1;
    int rShift = (int) r5 << 11;
    int bShift = (int) g5 << 6;
    int gShift = (int) b5 << 1;
    // Combine and return
    int abgr5551 = (int) (bShift | gShift | rShift | a1);
    output.write(new BigDecimal((abgr5551) & 0xFF).byteValue());
    output.write(new BigDecimal((abgr5551 >> 8) & 0xFF).byteValue());
    return abgr5551;
}