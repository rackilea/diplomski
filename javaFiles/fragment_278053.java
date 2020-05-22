public double powN(int n) {
    if (n < 0) {
      throw new UnsupportedOperationException("Only positive values are supported");
    }
    double tmp = 1;
    for (int i = 0; i < n; i++) {
      tmp = tmp * getX();
    }
    return tmp;
  }