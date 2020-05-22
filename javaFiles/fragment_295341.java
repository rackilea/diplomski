public void paintComponent(Graphics g) {
    if (firstDraw) {
        q.draw(g, scale, new Point(0, 0));
        s.drawScaledGeometry(g);
        System.out.println("Totally drew that");
        firstDraw = false;
    } else {
        g.clearRect(s.viewDistance.x/scale, s.viewDistance.y/scale,
            s.viewDistance.width/scale, s.viewDistance.height/scale);
        q.quadDraw(g, scale, s.viewDistance, new Point(0, 0));
        s.drawScaledGeometry(g);
    }
}