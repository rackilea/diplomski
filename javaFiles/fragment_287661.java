@Override 
protected void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
    g.setColor(Color.BLACK);
    g2.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    g.drawArc(getWidth()/2 -arcWidth/2, getHeight()/2 - arcHeight/2, arcWidth, arcHeight, 0, 360);
}