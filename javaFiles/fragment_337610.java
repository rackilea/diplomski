static class Player{
    int x;
    int y;

   Player(int x){this.x=x;}

   void moveUp(){y--;}
   void moveDown(){y++;}

   void drawPlayer(Graphics2D g){
       g.fillRect(x,y,40,120);
   }

}