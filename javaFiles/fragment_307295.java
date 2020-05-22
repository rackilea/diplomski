public class ImageTest2 {

    public static void main(String[] args) throws IOException {
        f(new File(args[0]));
    }

    static void f(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);

        // TODO: Test if image has transparency before doing anything else,
        // otherwise just copy the original as-is, for even better performance

        Graphics2D g = image.createGraphics();

        try {
            // Here's the trick, with DstOver we'll paint "behind" the original image
            g.setComposite(AlphaComposite.DstOver); 
            g.setColor(Color.GRAY);
            g.fill(new Rectangle(0, 0, image.getWidth(), image.getHeight()));
        }
        finally {
            g.dispose();
        }

        File out = new File(file.getParent() + File.separator + file.getName().replace('.', '_') + "_out.gif");
        ImageIO.write(image, "GIF", out);
    }
}