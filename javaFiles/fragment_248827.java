class GameObject {
  RectangularShape shape;
  ...
}

class Ball extends GameObject {
  public Ball(double Xin, double Yin, double widthIn, double heightIn) {
    // passes in variables and creates a new Ellipse2D
    posX = Xin;
    posY = Yin;
    width = widthIn;
    height = heightIn;
    shape = new Ellipse2D.Double(posX, posY, width, height);
  }