// Modified - Changed to int as pixels are ints
int diff;
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
        diff = Math.abs(r1 - r2); // Change
        diff += Math.abs(g1 - g2);
        diff += Math.abs(b1 - b2);

        // Check for any differences
        if (diff != 0) {
           r1 = 255;  // If there is, set output to yellow
           g1 = 255;
           b1 = 0;
           /* // Use this for purple / magenta
           r1 = 255;
           g1 = 0;
           b1 = 255; */
        }

        // If there are no differences, r1, g1 and b1
        // will contain the original colours for image 1
        // If there is, then r1, g1, b1 will be set to yellow

        // Set output pixel
        result = (r1 << 16) | (g1 << 8) | b1;
        outImg.setRGB(j, i, result); // Set result
    }
}