float initSize = 30;
float ballsizeX = initSize;
float ballsizeY = initSize;
float ballX = initSize/2;
float ballY = initSize/2;
float speedX = 2;
float speedY = 2;

void setup() {   
    size(500, 400);
}
void draw() {   
    background(255);   
    fill(random(255), 255, random(255));   
    ellipse(ballX, ballY, ballsizeX, ballsizeY);   
    speedX = speedX * 1;   
    speedY = speedY * 1;   
    ballX = ballX + speedX;   
    ballY = ballY + speedY;

    if ( ballsizeX > initSize ) {
         ballsizeX = ballsizeX - 1;
    }
    if ( ballsizeY > initSize ) {
         ballsizeY = ballsizeY - 1;
    }  

    if (ballX < initSize/2 || ballX > width-initSize/2) {     
        speedX = speedX * (-1);  
        ballsizeY = 60;
     } else if (ballY < initSize/2 || ballY > height-initSize/2) {     
        speedY = speedY * (-1);
        ballsizeX = 60;
    }
}