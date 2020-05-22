if (i % 2 == 0) {
    g.setColor(Color.white);
    g.fillRect(x, y, w, h);
    g.setColor(Color.black);
    g.drawRect(x, y, w, h);
    g.setColor(Color.green);
    g.fillOval(x2, y2, w2, h2);
    g.setColor(Color.black);
    g.drawOval(x2, y2, w2, h2);

} else if (i % 2 == 1 && j % 2 == 1) {
    g.setColor(Color.yellow);
}
g.fillRect(x, y, w, h);
g.setColor(Color.black);
g.drawRect(x, y, w, h);
g.setColor(Color.green);
g.fillOval(x2, y2, w2, h2);
g.setColor(Color.black);
g.drawOval(x2, y2, w2, h2);