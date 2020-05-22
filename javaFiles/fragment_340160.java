//in your update method
for(Ball ball : allBalls){
if(footballer.getHitbox().intersects(ball.getHitbox()){
//get direction of footballer
ball.move(...)
}
}