short[] data = /* your data */;
int[] cmap = /* as above */;
int[] rgb = new int[data.length];

for(int i = i; i < rgb.length; ++i) {
   rgb[i] = cmap[data[i]];
}

BufferedImage image = new BufferedImage(
   VERTICAL_PIXELS, HORIZONTAL_PIXELS, 
   BufferedImage.TYPE_INT_RGB);

image.setRGB(0, 0, VERTICAL_PIXELS, HORIZONTAL_PIXELS,
   pixels, 0, VERTICAL_PIXELS);