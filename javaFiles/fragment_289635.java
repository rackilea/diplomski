public void move() {  

 SpriteBase follower = this;  

 if( target != null)  
 {  
  //get distance between follower and target  
  double distanceX = target.getCenterX() - follower.getCenterX();  
  double distanceY = target.getCenterY() - follower.getCenterY();  

  //get total distance as one number  
  double distanceTotal = Math.sqrt(distanceX * distanceX + distanceY * distanceY);  

  //calculate how much to move  
  double moveDistanceX = this.turnRate * distanceX / distanceTotal;  
  double moveDistanceY = this.turnRate * distanceY / distanceTotal;  

  //increase current speed  
  follower.dx += moveDistanceX;  
  follower.dy += moveDistanceY;  

  //get total move distance  
  double totalmove = Math.sqrt(follower.dx * follower.dx + follower.dy * follower.dy);  

  //apply easing  
  follower.dx = missileSpeed * follower.dx/totalmove;  
  follower.dy = missileSpeed * follower.dy/totalmove;  

 }   

 //move follower  
 follower.x += follower.dx;  
 follower.y += follower.dy;  

 //rotate follower toward target  
 double angle = Math.atan2(follower.dy, follower.dx);  
 double degrees = Math.toDegrees(angle) + 90;  

 follower.r = degrees;  

}