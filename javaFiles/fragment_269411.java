// calc the deltas as next minus current
double delta_x = next.xPos - current.xPos;
double delta_y = next.yPos - current.yPos;

// Calc the angle IN RADIANS using the atan2
double theta = Math.atan2(delta_y, delta_x);

// this.angle is now in degrees
// or leave off *180/Math.PI if you want radians
this.angle = theta*180/Math.PI;