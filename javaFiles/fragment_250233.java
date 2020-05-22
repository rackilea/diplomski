public int[] moveValueAtIndexToFront(int[] arrayToBeShifted, int index) {
  int valueBeingMoved = originalArray[index];

  for (int i = index; i > 0; i--) {
    arrayToBeShifted[i] = arrayToBeShifted[i-1];
  }

  arrayToBeShifted[0] = valueBeingMoved;

  return arrayToBeShifted;
}