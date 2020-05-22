//Declare
int numTri = 6;//number of triangles
tri[] triangles = new tri[numTri];//a list/an array of tri objects (currently empty)
float angleIncrement = TWO_PI/numTri;
float radius = 100;
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