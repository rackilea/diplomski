public void repaint(long tm, int x, int y, int width, int height) {
...
         PaintEvent e = new PaintEvent(this, PaintEvent.UPDATE,
                                          new Rectangle(x, y, width, height));
         SunToolkit.postEvent(SunToolkit.targetToAppContext(this), e);
     }
}