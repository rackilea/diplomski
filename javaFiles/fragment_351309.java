double direction = ?; // the current direction of object in radians
double x = ?;  // the current position
double y = ?;
double maxTurn = ?; // Max turn speed in radians
double speed = ?;
void move() {
   double mvx = mouseX - x;   // get vector to mouse
   double mvy = mouseY - y;
   double dist = Math.sqrt(mvx * mvx + mvy * mvy);  // get length of vector
   if(dist > 0){  // must be a distance from mouse
       mvx /= dist;  // normalize vector
       mvy /= dist; 
       double ovx = Math.cos(direction); // get direction vector
       double ovx = Math.sin(direction);
       double angle = Math.asin(mvx * ovy - mvy * ovx); // get angle between vectors
       if(-mvy * ovy - mvx * ovx < 0){ // is moving away
          angle = Math.sign(angle) * Math.PI - angle;  // correct angle
       }
       // angle in radians is now in the range -PI to PI
       // limit turn angle to maxTurn
       if(angle < 0){
          if(angle < -maxTurn){
             angle = -maxTurn;
          }
       }else{
          if(angle > maxTurn){
             angle = maxTurn;
          }
       }
       direction += angle; // turn 
       // move along new direction
       x += Math.cos(direction) * speed;
       y += Math.sin(direction) * speed;
    }
}