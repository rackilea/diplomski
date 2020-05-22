import org.openkinect.*;
import org.openkinect.processing.*;

Kinect kinect;

void setup() {
  size(640,480);
  kinect = new Kinect(this);
  kinect.start();
  kinect.enableDepth(true);
}

void draw() {
  background(0);
  image(kinect.getDepthImage(),0,0);
}

void stop() {
  kinect.quit();
  super.stop();
}