public void mousePressed(MouseEvent e) {    //when clicked add point for 3 times

    if (i==0) {
    ...
    }
    else if (i==1) {
        p2 = e.getPoint();
        System.out.println("coordinates Point2: X=" + p2.getX() + ". Y=" + p2.getY());

        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double distanceAB = distanceAB(x1, y1, x2, y2);
        System.out.println("the distance between the points AB is " + distanceAB + ".");
    }
    ... 
}