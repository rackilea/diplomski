// Modified - Changed to int as pixels are ints
int rDiff, gDiff, bDiff;
int result; // Stores output pixel
for (int i = 0; i < height1; i++) {
    for (int j = 0; j < width1; j++) {
        int rgb1 = img1.getRGB(j, i);
        int rgb2 = img2.getRGB(j, i);
        int r1 = (rgb1 >> 16) & 0xff;
        int g1 = (rgb1 >> 8) & 0xff;
        int b1 = (rgb1) & 0xff;
        int r2 = (rgb2 >> 16) & 0xff;
        int g2 = (rgb2 >> 8) & 0xff;
        int b2 = (rgb2) & 0xff;
        rDiff = Math.abs(r1 - r2); // Change
        gDiff = Math.abs(g1 - g2);
        bDiff = Math.abs(b1 - b2);
        result = (rDiff << 16) | (gDiff << 8) | bDiff;
        outImg.setRGB(j, i, result); // Set result
    }
}