public void moveBall(){
ball.x += speed;

//checks if the ball intersects with the paddle Player 1 
if (ball.intersects(player2) ){
    speed *= (-1);
   ball.x += 3*speed;
}