public int[] getRGB(
       int xStart, int yStart, int w, int h, int[] rgbArray, int offset, int scansize) {

    final int[] result = rgbArray!=null? rgbArray: new int[offset+h*scansize];
    IntStream.range(yStart, yStart+h).parallel()
        .forEach(y -> getRealRGB(xStart, y, w, 1, result, offset+y*scansize, scansize));
    return result;
}