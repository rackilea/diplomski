static double[][] clone(double[][] array) {
  double[][] result = new double[array.length][];
  for(int i = 0; i < array.length; i++) {
    result[i] = array[i];
  }
  return result;
}