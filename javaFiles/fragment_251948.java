@Override
public void paintComponent(Graphics g) {
  for(Object gO:paintList) {
    g.drawImage( gO.getObjImage(), gO.getXLoc(), gO.getYLoc(), outer.getTransparent(), null);
  }
}