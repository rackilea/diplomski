protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.red);
    for (int col = 0; col < 50; col++) {
        for (int row = 0; row < 50; row++) {
            g.drawRect(row * cellSize, col * cellSize, cellSize, cellSize);
        }
    }
}