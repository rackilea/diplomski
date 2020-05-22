/* returns the index first/last occurrence of a value, or one past 
   where the element would have been if missing */
static int indexOf(int array[], int bound, boolean last) {
  int index = Arrays.binarySearch(array, bound);
  if (last && index >= 0) {
    while (index < array.length && array[index] == bound) index++;
  }
  return index < 0 ? -index - 1 : index;
}

static int subRange(int a[], int low, int high) {
  return Arrays.copyOfRange(a, indexOf(a, low, false), indexOf(a, high, true));
}