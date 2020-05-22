public Triangles(int numTriangles, double radius) {
    this.numTriangles = numTriangles;
    this.radius = radius;
    this.twoTheta = 360/this.numTriangles;
    this.theta = this.twoTheta/2;
    runCalculation();
}