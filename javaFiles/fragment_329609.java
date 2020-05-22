public void paint(Graphics g) {
    super.paint(g);
    for (int i = 0; i < this.numberOfRects; i++)
        paintRect(g);
    for (int i = 0; i < this.numberOfEllis; i++)
        paintOval(g);
    for (int i = 0; i < this.numberOfLines; i++)
        this.paintLine(g);
}