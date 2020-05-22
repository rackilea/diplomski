@Override
public void paintComponent(Graphics g) {
  synchronized(paintList) {
    for(Object gO:paintList) {
      g.drawImage( gO.getObjImage(), gO.getXLoc(), gO.getYLoc(), outer.getTransparent(), null);
    }
  }
}