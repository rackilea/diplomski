JPanel panel = new JPanel() {
    private static final long serialVersionUID = 1L;
    private Image image = new ImageIcon("Images/mong.jpg").getImage();

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
};