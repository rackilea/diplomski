public static boolean isContiguous(int[] array) {
  for (int i = 0; i < array.length-1; i++) {
     if (array[i+1]-array[i] != 1) {
        return false;
     }
  }
  return true;
}