double width;
  double length;

  public Triangle(Point point1, Point point2, Point point3) 
  { 
    x1=point1.getX();
    y1=point1.getY();
    x2=point2.getX();
    y2=point2.getY();
    x3=point3.getX();
    y3=point3.getY();

    // init width and length after x1,x2,y3,y2 are intialized
    width=x1-x2;
    length=y3-y2;
  }