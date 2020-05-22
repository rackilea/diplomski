public void paint(Graphics g2d){
    // Drawing the rotated image at the required drawing locations
    if(op!=null) g2d.drawImage(op.filter(currentImg, null), (int)x, (int)y, null);
    else g2d.drawImage(currentImg, (int)x, (int)y, null);
    g2d.setColor(Color.blue);
    g2d.fillOval(gunX, gunY, 10, 10);
}


public void move(double xM, double yM){
    x += xM * Math.cos(Math.toRadians(angle));
    y += yM * Math.sin(Math.toRadians(angle));

    gunY += yM * Math.sin(Math.toRadians(angle));
    gunX += xM * Math.cos(Math.toRadians(angle));

    repaint();
}


public void turn(double angle){    
    this.angle += angle;
    double rotationRequired = Math.toRadians (this.angle);
    double locationX = currentImg.getWidth() / 2;
    double locationY = currentImg.getHeight() / 2;
    AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
    op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
    int gx= currentImg.getWidth() - 15;
    int gy=0;
    Point pt1=new Point(gx, gy), pt2=new Point();
    tx.transform(pt1, pt2);
    gunX=(int)x+pt2.x; gunY=(int)y+pt2.y;
    repaint();
}