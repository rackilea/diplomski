//Declare
int numTri = 6;//number of triangles
tri[] triangles = new tri[numTri];//a list/an array of tri objects (currently empty)
float angleIncrement = TWO_PI/numTri;
float radius = 100;
boolean[] options = {false,false,false}; 
void setup() {
  size(600, 600);
  smooth();

  //Initialise
  for(int i = 0 ; i < numTri; i++){
    triangles[i] = new tri();//allocate/initialise each tri object into it's 'slot' in the list/array
  }
}

void draw() {
  background(0);
  translate(width * .5, height * .5);//move everything to the centre
  for(int i = 0 ; i < numTri; i++){
    pushMatrix();
      rotate(angleIncrement * i);//rotate from the last offset(centre)
      translate(radius,0);//move on (rotated) X axis away from the centre
      drawAxes(20);
      triangles[i].run();
    popMatrix();
  }
}
void drawAxes(int size){
  pushStyle();
  stroke(255,0,0);
  line(0,0,size,0);
  stroke(0,255,0);
  line(0,0,0,size);
  popStyle();
}
void keyReleased(){
  for(int i = 0 ; i < 3; i++) if(key == (49+i)) options[i] = !options[i];//quick'n'dirty option toggling
  for(int i = 0; i < numTri; i++) {
    triangles[i].rotateAroundCentre = options[0];
    triangles[i].translateAroundCentre = options[1];
    triangles[i].translateVertically = options[2];
  }
}
class tri {
  //Variables
  float ai = TWO_PI/3;//angle increment
  float r  = 50;
  float sr = r * 1.5;//spin radius
  float vt = 5;//vertical translation(for pulse)
  PVector[] verts = new PVector[3];

  boolean rotateAroundCentre = false;
  boolean translateAroundCentre = false;
  boolean translateVertically = false;
  //Construct
  tri() {
    for(int i = 0 ; i < 3; i++){
      verts[i] = new PVector(cos(ai * i) * r,sin(ai * i) * r);
    }
  }

  //Functions
  void run() {
    pushMatrix();
      float angle = millis()*0.0005;
      if(rotateAroundCentre) rotate(angle);
      drawAxes(30);

      if(translateVertically) translate(sin(angle)*vt,0);
      drawAxes(40);

      if(translateAroundCentre){
//        translate(cos(angle) * sr,sin(angle) * r);
//        or          
          rotate(angle);
          drawAxes(40);

          translate(sr,0);   
      }
    display(); //show triangle
    popMatrix();
  }
  void display() {
    fill(255);
    strokeWeight(0.8);
    triangle(verts[0].x, verts[0].y, verts[1].x, verts[1].y, verts[2].x, verts[2].y);
    drawAxes(10);
  }
}