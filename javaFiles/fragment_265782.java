void move()
 {
   x=x-speedX;
   float stepY = random(-5,5);
   y = y + (int)stepY;
   if(this.x < 0) {
      this.x = 800; // or width, startingPosition, ...
   }
 }