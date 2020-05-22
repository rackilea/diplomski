import dLibs.freenect.toolbox.*;
import dLibs.freenect.constants.*;
import dLibs.freenect.interfaces.*;
import dLibs.freenect.*;

Kinect kinect;                     // main kinect-object
KinectFrameDepth kinectDepth;     // depth frame
PImage depthFrame;

void setup(){
  size(640,480);
  kinect = new Kinect(0);
  kinectDepth = new KinectFrameDepth(DEPTH_FORMAT._11BIT_);// create a depth instance
  kinectDepth.connect(kinect);  //connect the created depth instance to the main kinect
  depthFrame = createImage(DEPTH_FORMAT._11BIT_.getWidth(), DEPTH_FORMAT._11BIT_.getHeight(), RGB);
}
void draw(){
  assignPixels(depthFrame, kinectDepth);
  image(depthFrame, 0, 0);
}
void assignPixels(PImage img, Pixelable kinectDev){
  img.loadPixels();
  img.pixels = kinectDev.getPixels();  // assign pixels of the kinect device to the image
  img.updatePixels();
}
void dispose(){
  Kinect.shutDown(); 
  super.dispose();
}