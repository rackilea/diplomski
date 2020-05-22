int x = e.getX();
       int y = e.getY();

       if(x>330 && x<280 && y>20 && y<20)
       {
           closeDoors = !closeDoors;
           repaint();

       }