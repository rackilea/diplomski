divide() {
    //....
    Triangle t1 = new Triangle(a, ab, ac);
    //...
}


public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
  this.a = a;
  this.b = b;
  this.c = c;
  triangles.add(this);  //this is the place where you modify triangles
}