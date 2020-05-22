public class ImageIconToBuffer {
    public static Buffer convert(ImageIcon img) {
        try {
            BufferedImage image = toBufferedImage(img);

            byte[] bytes = toByteArray(image);

            Buffer buffer = new Buffer(bytes);
            return buffer;
        } catch (IOException e) {
            return null;
        }
    }

    public static byte[] toByteArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();            
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
        encoder.encode(image);   

        return baos.toByteArray();
    }

    public static BufferedImage toBufferedImage(ImageIcon icon) {
        Image img = icon.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);

        Graphics2D bGr = bi.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bi;
    }

}