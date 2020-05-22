public class AdvertisementPanel extends JPanel {
    private BufferedImage image;
    private ArrayList<String> pictures;
    private int index = 0;

    public AdvertisementPanel(String... pics) {
        pictures = new ArrayList<String>(Arrays.asList(pics));
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
            new Runnable() {
                @Override
                public void run() {
                    changeImage();
                }
            }, 0, 5, TimeUnit.SECONDS);
    }

    private void changeImage() {
        final BufferedImage img = nextImage();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                image = img;
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }
    }

    private BufferedImage nextImage() {
        String name = pictures.get(index);
        try {
            index++;
            index %= pictures.size();
            File input = new File(name);
            return ImageIO.read(input);
        } catch (IOException ie) {
            Logger.getLogger("").log(Level.SEVERE,
                    "No adds found in given path: " + name);
            return null;
        }
    }
}