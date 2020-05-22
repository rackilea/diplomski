import SimpleOpenNI.*;
import processing.video.*;
import gab.opencv.*;
SimpleOpenNI  context;
OpenCV opencv;
PImage mask;
int numPixels = 640*480;
int dilateAmt = 1;
int erodeAmt = 1;
int blurAmt = 1;
Movie mov;
void setup(){
  opencv = new OpenCV(this, 640, 480);
  size(640*2, 480);
  context = new SimpleOpenNI(this);
  if (context.isInit() == false) {        
    exit();
    return;
  }
  context.enableDepth(); 
  context.enableRGB();
  context.enableUser();
  context.alternativeViewPointDepthToImage();  
  mask = createImage(640, 480, RGB);
  mov = new Movie(this, "wild.mp4");
  mov.play();
  mov.speed(5);
  mov.volume(0);
}
void movieEvent(Movie m) {
  m.read();
}
void draw() {
  frame.setTitle(int(frameRate) + " fps");     
  context.update();
  int[] userMap = context.userMap();  
  background(0, 0, 0); 
  mask.loadPixels();  
  for (int i = 0; i < numPixels; i++) {
    mask.pixels[i] = userMap[i] > 0 ? color(255) : color(0);
  }
  mask.updatePixels();
  opencv.loadImage(mask);
  opencv.gray(); 
  for (int i = 0; i < erodeAmt; i++) {
    opencv.erode();
  }
  for (int i = 0; i < dilateAmt; i++) {
    opencv.dilate();
  }  
  if (blurAmt>0) {//blur with 0 amount causes error
    opencv.blur(blurAmt);
  }  
  mask = opencv.getSnapshot();  
  image(mask, 0, 0);
  PImage rgb = context.rgbImage();  
  rgb.mask(mask);  
  image(mov, context.depthWidth() + 10, 0);
  image(rgb, context.depthWidth() + 10, 0);
  fill(255);
  text("erodeAmt: " + erodeAmt + "\tdilateAmt: " + dilateAmt + "\tblurAmt: " + blurAmt, 15, 15);
}
void keyPressed() {
  if (key == 'e') erodeAmt--;
  if (key == 'E') erodeAmt++;
  if (key == 'd') dilateAmt--;
  if (key == 'D') dilateAmt++;
  if (key == 'b') blurAmt--;
  if (key == 'B') blurAmt++;
  //constrain values
  if (erodeAmt < 0) erodeAmt = 0;
  if (dilateAmt < 0) dilateAmt = 0;
  if (blurAmt < 0) blurAmt = 0;
}