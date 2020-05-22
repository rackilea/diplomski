public void mouseClicked(MouseEvent e) {
       int x = e.getX();
       int y = e.getY();

       //check if (x,y) lie in a certain rectangle
       if(x>100 && x<300 && y>100 && y<300){
           //set a variable and repaint
           closeDoors = true;
           repaint();
       }
   }