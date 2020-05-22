class tri {
  //Variables
  float ax, ay, bx, by, cx, cy; //triangle point coordinates
  float theta; //triangle angle
  float pi = PI; //pi reference

  //Construct
  tri() {
    theta = PI/6;
    ax = 0;
    ay = 0;
    bx = -50*(sin(theta));
    by = +50*(cos(theta));
    cx = +50*(sin(theta));
    cy = +50*(cos(theta));
  }

  //Functions
  void run() {
    pushMatrix();
    revolve(); //revolve triangle about centre
//    pulse(); //move triangle in/out
    display(); //show triangle
    popMatrix();
  }

  void revolve() {
    translate(-2*by, 0);
    float angle = millis()*0.005;
    float cos = cos(angle);
    float sin = sin(angle);
    ax = ax + 2*sin;
    ay = ay + 4*cos;
    bx = bx + 2*sin;
    by = by + 4*cos;
    cx = cx + 2*sin;
    cy = cy + 4*cos;
    translate(2*by, 0);
  }

  void pulse() {
    ay = ay + 5*sin(millis()*0.005);
    by = by + 5*sin(millis()*0.005);
    cy = cy + 5*sin(millis()*0.005);
  }

  void display() {
    fill(255);
    strokeWeight(0.8);
    triangle(ax, ay, bx, by, cx, cy);
  }
}