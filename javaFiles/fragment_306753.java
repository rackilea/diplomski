class Sample extends JPanel {
    BufferedImage image;

    Pseudo(BufferedImage image) {
        this.image = image;
        // or load it in this class
        setLayout(null);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x =
        int y =
        g.drawImage(image, x, y, this);
    }
}