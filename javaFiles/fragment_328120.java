public class Int32Image {
    public static void main(String[] args) {
        // Define dimensions and layout of the image
        int w = 300;
        int h = 200;
        int transferType = DataBuffer.TYPE_INT;
//        int transferType = DataBuffer.TYPE_USHORT;

        ColorModel colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), false, false, Transparency.OPAQUE, transferType);
        WritableRaster raster = colorModel.createCompatibleWritableRaster(w, h);
        BufferedImage image = new BufferedImage(colorModel, raster, false, null);

        // Start with linear gradient
        if (raster.getTransferType() == DataBuffer.TYPE_INT) {
            DataBufferInt buffer = (DataBufferInt) raster.getDataBuffer();
            int[] data = buffer.getData();

            for (int y = 0; y < h; y++) {
                int value = (int) (y * 0xffffffffL / h);

                for (int x = 0; x < w; x++) {
                    int offset = y * w * 3 + x * 3;
                    data[offset] = value;
                    data[offset + 1] = value;
                    data[offset + 2] = value;
                }
            }
        }
        else if (raster.getTransferType() == DataBuffer.TYPE_USHORT) {
            DataBufferUShort buffer = (DataBufferUShort) raster.getDataBuffer();
            short[] data = buffer.getData();

            for (int y = 0; y < h; y++) {
                short value = (short) (y * 0xffffL / h);

                for (int x = 0; x < w; x++) {
                    int offset = y * w * 3 + x * 3;
                    data[offset] = value;
                    data[offset + 1] = value;
                    data[offset + 2] = value;
                }
            }
        }

        // Paint something (in  color)
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w / 2, h);
        g.setColor(Color.ORANGE);
        g.fillOval(100, 50, w - 200, h - 100);
        g.dispose();

        System.out.println("image = " + image);

//        image = new ColorConvertOp(null).filter(image, new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB));

        JFrame frame = new JFrame();
        frame.add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}