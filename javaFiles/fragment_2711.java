private void encodePass(ImageOutputStream os,
                        RenderedImage image,
                        int xOffset, int yOffset,
                        int xSkip, int ySkip) throws IOException {
    // (...)
    for (int row = minY + yOffset; row < minY + height; row += ySkip) {
                Rectangle rect = new Rectangle(minX, row, width, 1); // <--- *1
                Raster ras = image.getData(rect); // <--- *2