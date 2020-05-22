//given these variables already have value
double fps, currentX, destinationX, currentY, destinationY, animationLength; //animation length in seconds
...
double xValue = Math.abs(currentX - destinationX);
double yValue = Math.abs(currentY - destinationY);
...
//on each update:
double amountToMoveX = xValue / (animationLength * fps);
double amountToMoveY = yValue / (animationLength * fps);
camera.setCenter(camera.getX() + amountToMoveX, camera.getY() + amountToMoveY)