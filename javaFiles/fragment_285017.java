if (up == true) {

    Rectangle futurerect = new Rectangle(px,py-=5,81,150);

    if(!futurerect.intersects(wallexample)){
        py-=5;
        repaint();
    }
}