int[] dst = new int[width * height];
for (int i = 0, j = 0; i < dst.length; i++) {
    int a = src[j++] & 0xff;
    int b = src[j++] & 0xff;
    int g = src[j++] & 0xff;
    int r = src[j++] & 0xff;
    dst[i] = (a << 24) | (r << 16) | (g << 8) | b;
}
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
image.setRGB(0, 0, width, height, dst, 0, width);