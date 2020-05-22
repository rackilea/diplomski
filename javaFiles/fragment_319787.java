public static void main(String[] args) {
    int w = 1760;
    int h = 2140;

    byte[] rawBytes = new byte[w * h * 2]; // This will be your input array, 7532800 bytes

    ShortBuffer buffer = ByteBuffer.wrap(rawBytes)
//            .order(ByteOrder.LITTLE_ENDIAN) // Try swapping the byte order to see sharp edges
            .asShortBuffer();

    // Let's make a simple gradient, from black UL to white BR
    int max = 65535; // Unsigned short max value
    for (int y = 0; y < h; y++) {
        double v = max * y / (double) h;

        for (int x = 0; x < w; x++) {
            buffer.put((short) Math.round((v + max * x / (double) w) / 2.0));
        }
    }

    final BufferedImage image = createNoCopy(w, h, rawBytes);
//    final BufferedImage image = createCopyUsingByteBuffer(w, h, rawBytes);

    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            JFrame frame = new JFrame("Test");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            frame.add(new JScrollPane(new JLabel(new ImageIcon(image))));

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    });
}