List<Coordinate> coordinates = new ArrayList<Coordinate>();
    Coordinate startPoint = QuadraticCurveTo.getStartPoint();        
    Coordinate controlPoint = QuadraticCurveTo.getControlPoint();    
    Coordinate endPoint_ = QuadraticCurveTo.getEndPoint();

    double s  = 0;
    double t = 1;

    while (s < t) {
      s += 0.1; 
      double controlParameter = (1 - s);
      Coordinate Q_0 = new Coordinate(controlParameter * startPoint.getX(), controlParameter * startPoint.getY()).offset(new Coordinate(s * controlPoint.getX(), s * controlPoint.getY()));          
      Coordinate Q_1 = new Coordinate(controlParameter * controlPoint.getX(), controlParameter * controlPoint.getY()).offset(new Coordinate(s * endPoint_.getX(), s * endPoint_.getY()));
      Coordinate R_0 = new Coordinate(controlParameter * Q_0.getX(), controlParameter * Q_0.getY()).offset(new Coordinate(s * Q_1.getX(), s * Q_1.getY()));
      coordinates.add(R_0);
    }