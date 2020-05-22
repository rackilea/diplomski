public double getSideLength(){
    double sideLength;
    double deltaX = x2 - x1;
    double deltaY = y2 - y1;
    double squaredSum = Math.pow(deltaX, 2) + Math.pow(deltaY, 2);

    sideLength = Math.sqrt(squaredSum);

    return sideLength;

}