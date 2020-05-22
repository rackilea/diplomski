public void paint(Graphics g) {
    int y = 20;
    for (String s : list) {
        g.drawString(s, 20, y);
        y += 15;  // 15 is just a guess. Play with it til you get it right
    }
}