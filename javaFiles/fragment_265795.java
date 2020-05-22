public void paintComponent(Graphics g) {
    for (Line l : game.mirrors) {
        g.setColor(Color.BLACK);
        g.drawLine(l.start.x, l.start.y, l.end.x, l.end.y);
    }
}