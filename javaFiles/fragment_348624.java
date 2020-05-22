public static double[] toPrimitive(Double[] array) {
  if (array == null) {
    return null;
  } else if (array.length == 0) {
    return EMPTY_DOUBLE_ARRAY;
  }
  final double[] result = new double[array.length];
  for (int i = 0; i < array.length; i++) {
    result[i] = array[i].doubleValue();
  }
  return result;
}