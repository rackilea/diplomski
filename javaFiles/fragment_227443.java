//Calculate the differences in position
float diffX = target.getCenterX() - this.x;
float diffY = target.getCenterY() - this.y;

//Calculate the angle
double angle = Math.atan2(diffY, diffX);

//Update the positions
x += Math.cos(angle) * speed;
y += Math.sin(angle) * speed;