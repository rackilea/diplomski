// code omitted for clarity

public double calculate(double _x , double _y , double _x1 , double _y1 ) {   
  double s; // variable declared locally, thus can be used only inside this method
  s = Math.sqrt((_x-_y)*(_x-_y)+(_x1-_y1)*(_x1-_y1));
  return s;
}

// code omitted for clarity

public String toString() {
  return s; // will give compiler-error, since symbol/variable "s" is not visible here, but only inside method calculate
}

// code omitted for clarity