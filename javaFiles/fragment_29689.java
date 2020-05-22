// Globals
  int inGame=1; // 1 when in game 0 when not
  int scoreDone=0;  // 1 when score written 0 when not.

private void tick() 
{
   //inGame is just a global variable to determine if still in game
   //move() is a method used to move the player object.
   if (inGame == 1) 
     move();
   if ((inGame == 0) && (scoreDone == 0))
   {
     Util.writeScore("scores", 10);
     scoreDone = 1;
   }
}