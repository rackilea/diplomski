@Override
protected void paintComponent(Graphics graphics) {
    int[] xS = new int[3];
    int[] yS = new int[3]; 
    super.paintComponent(graphics);
    for(int i = 0; i<3; i++){
        xS[i]=(int)(x[i]*scX);
        yS[i]=(int)(y[i]*scY);
    }
    graphics.fillPolygon(xS,yS,3);
}