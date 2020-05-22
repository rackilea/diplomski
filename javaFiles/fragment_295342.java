public void paintComponent(Graphics g) {
    super.paintComponent(g); // <-- Call me instead...
    //g.clearRect(0, 0, dimen / 20, dimen / 20);
    q.quadDraw(g, 1, s.viewDistance, s.getMoved());
    s.drawGeometry(g);
}