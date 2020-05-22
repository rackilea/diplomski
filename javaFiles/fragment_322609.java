// first update position, then update velocity
yPosition=yVelocity+yPosition;
if (yPosition >= floor) {
    // invert velocity and position w/ elasticity applied
    yVelocity = -yVelocity * elasticity;
    yPosition = floor - (yPosition - floor) * elasticity;
}
if(Math.abs(yVelocity) <= 2 && Math.abs(yPosition - floor) <= 2){
    // stop everything when close to rest
    yPosition=floor;
    yVelocity=0; 
} else {
    // otherwise accelerate, even after bounce
    yVelocity=yVelocity+yAccelleration;
}