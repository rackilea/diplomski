jPanel1 = new JPanel() {
    BufferedImage img;
    {
        try {
            img = ImageIO.read(getClass().getResource("/resources/stackoverflow5.png"));
        } catch (IOException ex) {  ex.printStackTrace(); }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

    }
};