JPanel imagePanel = new JPanel() {
    private static final long serialVersionUID = 1;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(), img.getHeight());
    }
};

// ...

plateau.add(new GridPane(22,22));
plateau.add(imagePanel);