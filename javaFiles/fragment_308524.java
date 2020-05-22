//sets the conditions for winning
int lose = 1;
boolean flip_sensor_value = false;

PFont myFont;
int lf = 10;
Paddle Paddle; //Error Here
Ball breakout;
int padWidth = 15;
int padHeight = 60;
int leftPaddlePos = 0;
int distWall = 20;
float lpp;
boolean Win = false;
PImage pStart;
PImage pEnd;
boolean Contact = false;
boolean started = false;
int timePlayed = 0;

//sets the game window up 
void setup() {
  size(1000, 600);

  myFont = createFont("FFScala", 16);
  textFont(myFont);

  rectMode(CENTER);
  ellipseMode(CENTER);

  Paddle = new Paddle(padWidth, padHeight, distWall, leftPaddlePos); //Error Here
  //creates the ball
  breakout = new Ball (15, width/2, height/2, 8, 2, 1, 1);
}
void showGUI() {

  stroke(87, 36, 124);
  line(width/2, 0, width/2, height);

  textSize(16);
  pushStyle();
  fill(87, 36, 124);
  popStyle();
  //Tells you that you won
  if (Win == true) {
    textSize(48);
    image(pEnd, 0, 0, width, height);
    pushStyle();
    fill(87, 36, 124);
    text("YOU WIN!!!", width/2 - 175, 100);
    popStyle();
  }
}
void draw() {
  background(247);
  //dislplays and updates the Ball
  breakout.display();
  breakout.update();

  Paddle.display(lpp);
  //Shows the graphical user interface
  showGUI();

  if (started == false) {
    image(pStart, 0, 0, width, height);
    println("Start");
  }
  timePlayed ++;  //Controls the timer in the game
  breakout.bRadius = breakout.bRadius + (timePlayed * 0.5);
}


void keyPressed() {
  if (started == true) {   //added for Start Screen
    breakout.keyPressed();
  }                        //added for Start Screen
  if (started == false) {  //added for Start Screen
    started = true;        //added for Start Screen
  }                        //added for Start Screen
}
//Separate Tab
class Paddle {

  float pWidth;
  float pHeight;
  float yPos;
  float xPos;

  Paddle(float ipWidth, float ipHeight, float ixPos, float iyPos) {

    pWidth = ipWidth;
    pHeight = ipHeight;
    xPos = ixPos;
    yPos = iyPos;
  }

  void display(float yPos) {
    pushStyle();
    fill(87, 36, 124);// or littleBits white(247)
    rect(xPos, yPos, pWidth, pHeight);
    popStyle();
  }
}

//Separate Tab
class Ball {
  Paddle Paddle; //Added so that it would accept the Class Paddle
  float bAngle = 0; //added to keep track of ball's current angle
  float bRadius; //add this line to create a vector for the ball

  int bSize;
  float xpos, ypos;
  float xspeed, yspeed;
  float xdir, ydir;

  Ball(int ibSize, float ixpos, float iypos, float ixspeed, float iyspeed, float ixdir, float iydir) {

    bSize = ibSize;
    xpos = ixpos;
    ypos = iypos;
    xspeed = ixspeed;
    yspeed = iyspeed;
    xdir = ixdir;
    ydir = iydir;
  }
  void display() {
    pushStyle();
    fill(87, 36, 124);
    ellipse(xpos+bSize/2, ypos+bSize/2, bSize, bSize);
    popStyle();
  }
  void update() {

    xpos = xpos + (xspeed * xdir);
    ypos = ypos + (yspeed * ydir);

    calcRadius();
  }
  void keyPressed() {

    if (keyCode=='`') {
      newGame();
    }

    if (keyCode=='1') {
      bSize++;
    }
    if (keyCode=='2') {
      bSize--;
    }
    if (keyCode=='3') {
      Paddle.pHeight++;
    }    
    if (keyCode=='4') {
      Paddle.pHeight--;
    }
  }

  void reset() {
    xpos = width;
    ypos = height/2;
    ydir = random(-1, 1);
    float dir = random(-1, 1);
    if (dir > 0) {
      xdir = 1;
    } else if (dir <= 0) {
      xdir = -1;
    }
    breakout.xspeed = 8; //reset ball speed
    breakout.yspeed = 2; //reset ball speed
    timePlayed = 0;  //reset time played counter
    bRadius = 8.25;  //reset ball vector
  }
  void newGame() {
    reset();
  }
  void calcRadius() { //added to calculate radius/vector of ball trajectory
    bRadius = sqrt(pow(abs(xspeed), 2) + pow(abs(yspeed), 2)); //added to figure out ball vector
  }
  void lPadHitTest() {
    if (xpos < Paddle.xPos - Paddle.pWidth/2 - bSize/2  //check to see if it's hitting paddle side to side
      && ypos < lpp + Paddle.pHeight/2 + bSize/2           //check to see if it's hitting paddle up and down
      && ypos > lpp - Paddle.pHeight/2 - bSize/2)          //check to see if it's hitting paddle up and down
    {
      lPadAngle();                                            //change the angle of the ball depending where it hits the paddle
      xdir *= -1;                                             //turn the ball around so it bounces
    }
  }
  void lPadAngle() {
    if (ypos < lpp - 10) {  //checks if y position is above the middle section of the right paddle
      println(bAngle);
      bAngle = bAngle + (map(abs(lpp - 10 - ypos), 0, 50, 0, 15));  //adds to angle of ball trajectory
      xspeed = cos (radians(bAngle)) * bRadius; //change ball's x speed
      yspeed = sin (radians(bAngle)) * bRadius; //change ball's y spped
      println(bAngle);
    }
    if (ypos < lpp + 10) {  //checks if y position is below the middle section of the right paddle
      println(bAngle);
      bAngle = bAngle - (map(abs(lpp + 10 - ypos), 0, 50, 0, 15));  //subtracts from angle of ball trajectory
      xspeed = cos (radians(bAngle)) * bRadius; //change ball's x speed
      yspeed = sin (radians(bAngle)) * bRadius; //change ball's y spped
      println(bAngle);
    }
    xpos = Paddle.xPos + Paddle.pWidth/2 + bSize/2; //corrects for sticking in right paddle
  }
}