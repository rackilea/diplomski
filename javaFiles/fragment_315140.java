class Texscroll extends JPanel {

    private int x = 510, y = 25;
    private final String string = "Text in moving similary to the tags HTML5 Marquesina (<marquee>).";
    private final Image image;

    public Texscroll() {
        Font font = new Font("Arial", Font.BOLD + Font.PLAIN, 15);
        setFont(font);
        setForeground(Color.BLACK);
        image = getImage();
        Timer timer = new Timer(14, arg0 -> {
            x -= 1;
            if (x == -10 * string.length()) {
                x = 510;
            }
            repaint();
        });
        timer.start();
        setPreferredSize(new Dimension(720, 480));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString(string, x, y);
        g2.drawImage(image, x, y + 100, getFocusCycleRootAncestor());
    }

    //use any image
    private BufferedImage getImage() {
        int iconWidth =100;
        BufferedImage img = new BufferedImage(iconWidth , iconWidth,
                                            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setColor(Color.RED);
        g2.fillOval(1, 1, iconWidth - 2, iconWidth - 2);
        g2.dispose();
        return img;
    }
}