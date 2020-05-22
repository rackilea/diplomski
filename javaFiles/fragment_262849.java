float roll, pitch, yaw;

float maxRoll = 360;
boolean invertRoll;

void setup() {
  size(400,400,P3D);
}

void draw() {
  background(255);

  pushMatrix(); // begin object
  translate(width/4, height/4); // set position

  float rollValue = roll;

  if(invertRoll) rollValue = maxRoll - roll;

  float c1 = cos(radians(rollValue));
  float s1 = sin(radians(rollValue));

  float c2 = cos(radians(pitch));
  float s2 = sin(radians(pitch));
  float c3 = cos(radians(yaw));
  float s3 = sin(radians(yaw));
  applyMatrix( c2*c3, s1*s3+c1*c3*s2, c3*s1*s2-c1*s3, 0, 
    -s2, c1*c2, c2*s1, 0, 
    c2*s3, c1*s2*s3-c3*s1, c1*c3+s1*s2*s3, 0, 
    0, 0, 0, 1);

  drawArduino();
  popMatrix(); // end of object
}

void drawArduino() {
  box(100);
}

void mouseDragged(){
  roll = map(mouseX,0,width,0,360);
}

void keyPressed(){
  invertRoll = !invertRoll;
}