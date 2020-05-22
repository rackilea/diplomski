public class SplitDataBufferTest {
    /** Custom DataBuffer implementation using separate arrays for RGB and alpha.*/
    public static class SWTDataBuffer extends DataBuffer {
        private final byte[] rgb; // RGB or BGR interleaved
        private final byte[] alpha;

        public SWTDataBuffer(byte[] rgb, byte[] alpha) {
            super(DataBuffer.TYPE_BYTE, alpha.length, 4); // Masquerade as banded data buffer
            if (alpha.length * 3 != rgb.length) {
                throw new IllegalArgumentException("Bad RGB/alpha array lengths");
            }
            this.rgb = rgb;
            this.alpha = alpha;
        }

        @Override
        public int getElem(int bank, int i) {
            switch (bank) {
                case 0:
                case 1:
                case 2:
                    return rgb[i * 3 + bank];
                case 3:
                    return alpha[i];
            }
            throw new IndexOutOfBoundsException(String.format("bank %d >= number of banks, %d", bank, getNumBanks()));
        }

        @Override
        public void setElem(int bank, int i, int val) {
            switch (bank) {
                case 0:
                case 1:
                case 2:
                    rgb[i * 3 + bank] = (byte) val;
                    return;
                case 3:
                    alpha[i] = (byte) val;
                    return;
            }

            throw new IndexOutOfBoundsException(String.format("bank %d >= number of banks, %d", bank, getNumBanks()));
        }
    }

    public static void main(String[] args) {
        // These are given from your SWT image
        int w = 300;
        int h = 200;
        byte[] rgb = new byte[w * h * 3];
        byte[] alpha = new byte[w * h];

        // Create an empty BufferedImage around the SWT image arrays
        BufferedImage image = createImage(w, h, rgb, alpha);

        // Just to demonstrate that it works
        System.out.println("image: " + image);
        paintSomething(image);
        showIt(image);
    }

    private static BufferedImage createImage(int w, int h, byte[] rgb, byte[] alpha) {
        DataBuffer buffer = new SWTDataBuffer(rgb, alpha);
        // SampleModel sampleModel = new BandedSampleModel(DataBuffer.TYPE_BYTE, w, h, 4); // If SWT data is RGB, you can use simpler constructor
        SampleModel sampleModel = new BandedSampleModel(DataBuffer.TYPE_BYTE, w, h, w,
                new int[] {2, 1, 0, 3}, // Band indices for BGRA
                new int[] {0, 0, 0, 0});

        WritableRaster raster = Raster.createWritableRaster(sampleModel, buffer, null);
        ColorModel colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), true, false, Transparency.TRANSLUCENT, DataBuffer.TYPE_BYTE);
        return new BufferedImage(colorModel, raster, colorModel.isAlphaPremultiplied(), null);
    }

    private static void showIt(final BufferedImage image) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                JLabel label = new JLabel(new ImageIcon(image));
                label.setOpaque(true);
                label.setBackground(Color.GRAY);
                frame.add(label);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private static void paintSomething(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        int qw = w / 4;
        int qh = h / 4;

        Graphics2D g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.ORANGE);
        g.fillOval(0, 0, w, h);

        g.setColor(Color.RED);
        g.fillRect(5, 5, qw, qh);
        g.setColor(Color.WHITE);
        g.drawString("R", 5, 30);

        g.setColor(Color.GREEN);
        g.fillRect(5 + 5 + qw, 5, qw, qh);
        g.setColor(Color.BLACK);
        g.drawString("G", 5 + 5 + qw, 30);

        g.setColor(Color.BLUE);
        g.fillRect(5 + (5 + qw) * 2, 5, qw, qh);
        g.setColor(Color.WHITE);
        g.drawString("B", 5 + (5 + qw) * 2, 30);

        g.dispose();
    }
}