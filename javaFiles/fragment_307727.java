public boolean checkBoundaries(int xSize, int ySize) {
     boolean check;
     if ((xSize==0 || xSize ==1 || xSize ==2) && (ySize==0 || ySize ==1 || ySize ==2)) {
         check = true;
     } else {
         check = false;
     }
 return check;
 }