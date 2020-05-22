public void recolor(Bitmap origBitmap, Bitmap newBitmap, Map<Integer, Integer> colorReplace) {
    final width = origBitmap.getWidth();
    final height = origBitmap.getHeight();
    final int[] pixels = new int[width * height];
    origBitmap.getPixels(pixels, 0, width, 0, 0, width, height);
    for (i = 0; i < pixels.length; i++) {
        pixels[i] = colorReplace.get(pixels[i])
    }
    newBitmap.setPixels(pixels, 0, width,0, 0, width, height);
}