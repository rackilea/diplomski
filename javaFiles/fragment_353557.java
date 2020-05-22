@override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;

    for (Point p : paintList) {
        int x = bresenham.get(i).x - pointWidth1/2;
        int y = bresenham.get(i).y - pointWidth1/2;

        int ovalW = pointWidth1;
        int ovalH = pointWidth1;

        g.fillOval(x, y, ovalW, ovalH);
    }
}