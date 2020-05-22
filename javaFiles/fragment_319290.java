public static int muchDarker(int rgb) {
    int r = (rgb >> 16) & 255;   // red
    int g = (rgb >> 8) & 255;    // green
    int b = rgb & 255;           // blue
    // now reduce brightness of all channels to 1/3
    r /= 3;
    g /= 3;
    b /= 3;
    // recombine channels and return
    return (r << 16) | (g << 8) | b;
}