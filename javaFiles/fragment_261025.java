//takes a point and rotates it `theta` angles 
//counterclockwise around the given center point
function rotateAboutPoint(x,y, centerX, centerY, theta){
    radius = sqrt((centerX-x)**2 + (centerY-y)**2)  //`**` is the exponentiation operator
    currentAngle = atan2(y-centerY, x-centerX)      //prefer `atan2` over ordinary `atan` if you can get it
    newAngle = currentAngle + theta
    newX = centerX + radius*cos(newAngle)
    newY = centerY + radius*sin(newAngle)
    return (newX, newY)
}

function pointInside(x,y){
    //point must be rotated clockwise, so we provide a negative angle
    newX, newY = rotateAboutPoint(x,y,center.x, center.y, -angle) 
    return (
        newY  > center.y - (getHeight() / 2) &&
        newY  < center.y + (getHeight() / 2) &&
        newX  > center.x - (getHeight() / 2) &&
        newX  < center.x + (getHeight() / 2) &&
    )
}