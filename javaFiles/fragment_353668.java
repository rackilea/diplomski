for (int i = width; i < 400 + width; i += 100) {
    for (int j = height; j < 400 + height; j += 100) {
        g.setColor(Color.white);
        g.fillRect(i, j, 50, 50);
        g.setColor(Color.black);
        g.drawRect(i, j, 50, 50);
    }
}
for (int i = width + 50; i < 400 + width; i += 100) {
    for (int j = height + 50; j < 400 + height; j += 100) {
        g.setColor(Color.white);
        g.fillRect(i, j, 50, 50);
        g.setColor(Color.black);
        g.drawRect(i, j, 50, 50);
    }
}