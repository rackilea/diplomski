class Circle {
   int getX () {
       int x = -1;
       if (getCenter() != null)
           x = getCenter().getX();
       return x;
   }
}

class Player {
   int getX () {
       int x = -1;
       if (getCircle() != null)
           x = getCircle().getX();
       return x;
   }
}