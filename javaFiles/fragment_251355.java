public static BufferedImage array_rasterToBuffer(int[][] imgR, int[][] imgG, int[][] imgB) {
    final int width = imgR[0].length;
    final int height = imgR.length;

    // The bands are "packed" for TYPE_INT_RGB Raster, 
    // so we need only one array component per pixel
    int[] pixels = new int[width * height];

    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            // "Pack" RGB values to native TYPE_INT_RGB format
            // (NOTE: Do not use Math.abs on these values, and without alpha there won't be negative values)
            pixels[((y * width) + x)] = ((imgR[y][x] & 0xff) << 16 | (imgG[y][x] & 0xff) << 8 | (imgB[y][x] & 0xff));
        }
    }

    BufferedImage bufferImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    // NOTE: getRaster rather than getData for "live" view
    WritableRaster rast = bufferImg.getRaster();

    // NOTE: setDataElements rather than setPixels to avoid conversion
    // This requires pixels to be in "native" packed RGB format (as above)
    rast.setDataElements(0, 0, width, height, pixels);

    // No need for setData as we were already working on the live data
    // thus saving at least two expensive array copies

    return bufferImg;
}

// Test method, displaying red/green/blue stripes
public static void main(String[] args) {
    int[][] fooR = new int[99][99];
    int[][] fooG = new int[99][99];
    int[][] fooB = new int[99][99];

    for (int i = 0; i < 33; i++) {
        Arrays.fill(fooR[i], 0xff);
        Arrays.fill(fooG[i + 33], 0xff);
        Arrays.fill(fooB[i + 66], 0xff);
    }

    BufferedImage image = array_rasterToBuffer(fooR, fooG, fooB);

    showIt(image);
}

// For demonstration only
private static void showIt(final BufferedImage image) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            JFrame frame = new JFrame("JPEGTest");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JScrollPane scroll = new JScrollPane(new JLabel(new ImageIcon(image)));
            scroll.setBorder(BorderFactory.createEmptyBorder());
            frame.add(scroll);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    });
}