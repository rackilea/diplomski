synchronized(lock) {
   int size = balls.size();
   for(int i = 0; i < size; i++){
         Ball ball = balls.get(i);
         drawBall(ball.xCoord, ball.yCoord, ball.image);
   }
}