//paintSurface constructor
....
this.addMouseMotionListener(new MouseMotionAdapter() {
    public void mouseDragged(MouseEvent e) {
      endDrag = new Point(e.getX(), e.getY());
      repaint();
    }//end mouseDragged     

   //TRY THIS CODE :-)       
   public void mouseMoved(MouseEvent e) {
      startDrag = new Point(e.getX(), e.getY());
      if (triangles.contains(startDrag))
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
      else
        setCursor(Cursor.getDefaultCursor());
    }// end mouseMoved
 });//end this.addMouseMotionListener
}//end paintSurface