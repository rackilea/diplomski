PImage ball_img;


void setup() {
  ball_img = loadImage("myImage.jpg");


  ball_a = new Ball(ball_img);
}


class Ball {

  PImage ballimg;

  ball(PImage img) {
    ballimg = img;
  }
}