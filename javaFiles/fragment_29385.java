synchronized(lock) {
   int size = balls.size();
   for(int i = size -1; i >= 0; i--){
       i.updateBallPosition();
       i.updateBallVelocity();

       if(i.isOutOfBounds())
           balls.remove(i);
   }
}