public void paint(Graphics e) {
    Graphics2D g = (Graphics2D) e;

    // red blue and orange are all hidden behind the other faces so you don't draw them
    // but if you did you just need to draw them first and the order doesn't matter
    // since they don't overlap
    //g.setColor(Color.RED);
    //g.fillPolygon(Xpoly1, Ypoly1, 4);
    //g.setColor(Color.BLUE);
    //g.fillPolygon(Xpoly3, Ypoly3, 4);
    //g.setColor(Color.ORANGE);
    //g.fillPolygon(Xpoly5, Ypoly5, 4);

    // since these three don't overlap you can draw them in any order as well.
    g.setColor(Color.PINK);
    g.fillPolygon(Xpoly6, Ypoly6, 4);
    g.setColor(Color.YELLOW);
    g.fillPolygon(Xpoly4, Ypoly4, 4);
    g.setColor(Color.GREEN);
    g.fillPolygon(Xpoly2, Ypoly2, 4);
}