public static void main(String[] args) throws IOException {

    Frame frame = new Frame("Test");
    frame.setUndecorated(true);

    frame.add(new Component() {
        BufferedImage img = ImageIO.read(new URL("http://upload.wikimedia.org/"+
                                                 "wikipedia/en/2/24/Lenna.png"));
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    });

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gs = ge.getDefaultScreenDevice();
    gs.setFullScreenWindow(frame);
    frame.validate();
}