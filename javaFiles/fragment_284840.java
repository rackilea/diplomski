public class Main {
    private static void createAndShowGUI() {
        //swing stuff
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Alpha Mask");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel picLabel = new JLabel(new ImageIcon(getImg()));
        frame.getContentPane().add(picLabel);

        BufferedImage alphaMask = createAlphaMask(getImg());

        JLabel maskLabel = new JLabel(new ImageIcon(alphaMask));
        frame.getContentPane().add(maskLabel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static BufferedImage getImg() {
        try {
            return ImageIO.read(new URL("https://i.stack.imgur.com/UPmqE.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage createAlphaMask(BufferedImage img) {
        //TODO: deep copy img here if you actually use this
        int width = img.getWidth();
        int[] data = new int[width];

        for (int y = 0; y < img.getHeight(); y++) {
            // pull down a line if argb data
            img.getRGB(0, y, width, 1, data, 0, 1);
            for (int x = 0; x < width; x++) {
                //set color data to black, but preserve alpha, this will prevent harsh edges
                int color = data[x] & 0xFF000000;
                data[x] = color;
            }
            img.setRGB(0, y, width, 1, data, 0, 1);
        }
        return img;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}