static double[][] copyArray(double[][] array) {
  double[][] result = new double[array.length][];
  for(int i = 0; i < array.length; i++) {
    result[i] = new double[array[i].length];
    for(int j = 0; j < array[i].length; j++) {
      result[i][j] = array[i][j];
    }
  }
  return result;
}