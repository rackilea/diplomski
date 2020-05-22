@Override 
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(colour);
    g.fillRect(0,0,getWidth(),getHeight());

    Graphics2D gg = (Graphics2D)g;

    double theta = (double)angle.getValue(); 
    theta = Math.toRadians(theta);
    gg.rotate(theta,tubeImage.getSize().width/2 + 10,tubeImage.getSize().height - 50);
    gg.fillRect(tubeImage.getSize().width/2,tubeImage.getSize().height - 100 , 10, 50);
}