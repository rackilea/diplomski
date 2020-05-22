for (int i = 0; i < arr.length; i += 4) {
  int tmp;
  // swap 0 and 3
  tmp = arr[i];
  arr[i] = arr[i + 3];
  arr[i + 3] = tmp;
  // swap 1 and 2
  tmp = arr[i + 1];
  arr[i + 1] = arr[i + 2];
  arr[i + 2] = tmp;
}