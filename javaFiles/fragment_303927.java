Cube(){
    // This is the constructor called.
    super();
    depth = 0;
}

Cube(int x, int y, int sideLength, int d){
    super(x, y, sideLength);
    this.depth = d;
}