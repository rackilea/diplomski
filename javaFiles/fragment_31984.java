/**
 * @brief draw the scene with all shapes set up
 * @param g1
 * @param x1
 * @param y1
 * @param xtg
 * @param r
 */
private void disposeScene(Graphics g1, int x1, int y1, XML_TO_GRAPH xtg, int r) {
    Graphics2D g = (Graphics2D) g1.create();
    g.translate(getWidth() / 2, getHeight() / 2);
     drawCircle(g, 0, 0, (x1+y1)/2); // cercle fictif
    for (int i = 0; i < xtg.getsceneVector().size(); i++) {
        double angle = Math.toRadians(360.0); // radian mieux 2pi

        angle = (angle*i / xtg.getsceneVector().size());
        System.out.println("angle(" + i + ")=" + angle);
        g.setColor(Color.RED);
        drawCircle(g, (int) (Math.cos(angle) * x1), (int) (Math.sin(angle) * y1), r);

        Point center_big_circle = new Point();
        center_big_circle.setLocation((0), (0)); // centre du grand cercle fictif
        Point center_little_circle = new Point();
        center_little_circle.setLocation((Math.cos(angle) * (x1)), (Math.sin(angle) * (y1))); // décalage vers les
                                                                                                // bords
        System.out.println("centre(" + i + ")=" + center_little_circle.getX() + "," + center_little_circle.getY());
        point_tab.add(center_little_circle);
        g.setColor(Color.BLACK);
        drawString(g, (int) center_little_circle.getX()-r, (int) center_little_circle.getY()-r, 16, "scène : " + i);
        System.out.println(point_tab.elementAt(i).getX() + "," + point_tab.elementAt(i).getY());
        g.setColor(Color.BLUE);
        if (i + 1 < point_tab.size()) {// si existe 
            drawArrow(g, point_tab.elementAt(i).getX(), point_tab.elementAt(i).getY(),
                    point_tab.elementAt(i + 1).getX(), point_tab.elementAt(i + 1).getY());
//              g.setColor(Color.BLACK);
//              drawString(g, (int)(( point_tab.elementAt(i+1).getX()-
point_tab.elementAt(i).getX())/2), (int) ((point_tab.elementAt(i+1).getY()-
point_tab.elementAt(i).getY())/2), 16, "X : " + 
xtg.getcount_occurence().toString());

            //idem
            drawArrow(g, point_tab.elementAt(i+1).getX(), point_tab.elementAt(i+1).getY(),
                    point_tab.elementAt(i).getX(), point_tab.elementAt(i).getY());
//              drawString(g, (int)(( point_tab.elementAt(i).getX()-
point_tab.elementAt(i+1).getX())/2), (int) ((point_tab.elementAt(i).getY()-
point_tab.elementAt(i+1).getY())/2), 16, "X : " + 
xtg.getcount_occurence().toString());

        }
    }

}