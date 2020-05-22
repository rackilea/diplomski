static BufferedImage BImageFrom2DArray(float data[][]) {
    int width = data.length;
    int height = data[0].length;
    BufferedImage myimage = new BufferedImage(width, height,  BufferedImage.TYPE_INT_RGB);
    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            int value = (int) ((1f - data[x][y]) * 255f);
            myimage.setRGB(y, x, (value << 16) | (value << 8) | value);
        }
    }
    return myimage;
}