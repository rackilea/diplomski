public void addRectangleAt(int x, int y)
   {
      Rectangle boxNew = new Rectangle(x, y, BOX_WIDTH, BOX_HEIGHT);
      boxes.add(boxNew);
      repaint();      
   }