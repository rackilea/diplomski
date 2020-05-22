public boolean arrayLessThan(int[] array) {
  for (int element: array) {
    if (element < 20) {
      return false;
    }
  }
  return true;
}