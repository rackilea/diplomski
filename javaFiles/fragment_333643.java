@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gr = g;
        g.drawImage(im, 0, 0, DIM_W, DIM_W, this);
    }