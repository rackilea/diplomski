import SimpleOpenNI.*;

SimpleOpenNI  ni;

void setup(){
  ni = new SimpleOpenNI(this);
  ni.enableDepth()
  size(ni.depthWidth(), ni.depthHeight()); 
}

void draw(){
  ni.update();
  image(context.depthImage(),0,0);
}