List<Integer> yClicks = new ArrayList<>();

... {
    addMouseListener(new MouseAdapter() {
       @Override
        public void mouseClicked(MouseEvent e) {
            yClicks.add(e.getY());
            repaint();
        }
    });
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D)g.create();

    for(int y : yClicks) {
        g2d.draw(new Line2D.Double(0, y, getWidth(), y));
    }

    g2d.dispose();
}