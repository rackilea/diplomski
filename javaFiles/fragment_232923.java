public boolean isIntersectingNode(double inputX,
                                  double inputY,
                                  double inputWidth,
                                  double inputHeight) {

    Rectangle2D inputRectangle = new Rectangle2D(inputX, inputY, inputWidth, inputHeight);
    double newX = 20, newY = 20, newW = 20, newH = 20;

    Rectangle2D scannedRectangle = new Rectangle2D(newX, newY, newW, newH);

    return inputRectangle.intersects(scannedRectangle);
}