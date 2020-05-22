public Mat bufferedImageToMat(BufferedImage bi) {
    Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CV_8UC(3));

    int r, g, b;
    UByteRawIndexer indexer = mat.createIndexer();
    for (int y = 0; y < bi.getHeight(); y++) {
        for (int x = 0; x < bi.getWidth(); x++) {
            int rgb = bi.getRGB(x, y);

            r = (byte) ((rgb >> 0) & 0xFF);
            g = (byte) ((rgb >> 8) & 0xFF);
            b = (byte) ((rgb >> 16) & 0xFF);

            indexer.put(y, x, 0, r);
            indexer.put(y, x, 1, g);
            indexer.put(y, x, 2, b);
        }
    }
    indexer.release();
    return mat;
}