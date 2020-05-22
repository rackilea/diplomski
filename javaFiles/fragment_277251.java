enum ElPosition {
  P1(
          (boxX() *0 + boxX() /2),
          (boxY() *0 + boxY() /2)
  ),
  P2(
          (boxX() *1 + boxX() /2),
          (boxY() *1 + boxY() /2)
  ),
  P3(
          (boxX() *2 + boxX() /2),
          (boxY() *2 + boxY() /2)
  );

  private double xPosition;
  private double yPosition;

  ElPosition(final double xPosition, final double yPosition) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
  }

  private static final double BOX_X = 10;
  private static final double BOX_Y = 10;

  private static double boxX() {
    return BOX_X;
  }

  private static double boxY() {
    return BOX_Y;
  }

  public double getXPosition() {
    return xPosition;
  }

  public double getYPosition() {
    return yPosition;
  }
}