class tri {
  //Variables
  float ai = TWO_PI/3;//angle increment
  float r  = 50;
  float sr = r * 1.5;//spin radius
  float vt = 5;//vertical translation(for pulse)
  PVector[] verts = new PVector[3];

  boolean rotateAroundCentre = true;
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
      if(translateVertically) translate(sin(angle)*vt,0);
      if(translateAroundCentre){
//        translate(cos(angle) * sr,sin(angle) * r);
//        or          
          rotate(angle);
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