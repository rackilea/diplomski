public void mouseMoved(MouseEvent e) {
      startDrag = new Point(e.getX(), e.getY());
      Cursor cursor = Cursor.getDefaultCursor();
      //you have a List<Polygon>, so you can use this enhanced for loop
      for (Polygon p : triangles) { 
        if (p.contains(startDrag)) {//Polygon has a 'contains(Point)' method
           cursor = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
           break; //you've found a hit, break from the loop 
        }
      }
      setCursor(cursor);
 }// end mouseMoved