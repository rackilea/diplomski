if (ballX < 0 || ballX > 500) {     
    speedX = speedX * (-1);  
    ballsizeY = initSize*2;
 } else if (ballY < 0 || ballY > 400) {     
    speedY = speedY * (-1);
    ballsizeX = initSize*2;
 }