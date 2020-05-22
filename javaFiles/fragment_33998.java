int[][] bilinearDownscale(int[][] original, int scale, boolean brighten) {
    int[][] result = new int[original.length / 2][original[0].length / 2];

    // the four pixels from which we derive our downscaled pixel
    // i = 0 -> red, i = 1 -> green, i = 2 -> blue
    int a[] = new int[3];
    int b[] = new int[3];
    int c[] = new int[3];
    int d[] = new int[3];
    for (int x = 0; x < result.length; x++) {
        for (int y = 0; y < result[0].length; y++) {

            // get the individual color values of the old pixels
            a[0] = (original[x * 2][y * 2]) >> 16 & 0xFF;
            b[0] = (original[x * 2 + 1][y * 2]) >> 16 & 0xFF;
            c[0] = (original[x * 2][y * 2 + 1]) >> 16 & 0xFF;
            d[0] = (original[x * 2 + 1][y * 2 + 1]) >> 16 & 0xFF;

            a[1] = (original[x * 2][y * 2]) >> 8 & 0xFF;
            b[1] = (original[x * 2 + 1][y * 2]) >> 8 & 0xFF;
            c[1] = (original[x * 2][y * 2 + 1]) >> 8 & 0xFF;
            d[1] = (original[x * 2 + 1][y * 2 + 1]) >> 8 & 0xFF;

            a[2] = original[x * 2][y * 2] & 0xFF;
            b[2] = original[x * 2 + 1][y * 2] & 0xFF;
            c[2] = original[x * 2][y * 2 + 1] & 0xFF;
            d[2] = original[x * 2 + 1][y * 2 + 1] & 0xFF;

            // get the individually interpolated color values
            int red = (int) (0.25 * (a[0] + b[0] + c[0] + d[0]));
            int green = (int) (0.25 * (a[1] + b[1] + c[1] + d[1]));
            int blue = (int) (0.25 * (a[2] + b[2] + c[2] + d[2]));

            // apply saturation if so desired
            if (brighten) {
                float hsb[] = Color.RGBtoHSB(red, green, blue, null);
                hsb[2] = -((hsb[2] - 1) * (hsb[2] - 1)) + 1;

                // compute the new color value
                result[x][y] = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
            } else {

                // compute the new color value
                result[x][y] = (red << 16) | (green << 8) | blue;
            }
        }
    }

    // yay recursion
    if (scale > 2) {
        return bilinearDownscale(result, scale / 2, brighten);
    }
    return result;
}