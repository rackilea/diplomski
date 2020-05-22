public static int binarySearch(int[] list, int key) {
  int low = 0;
  int high = list.length - 1;

  while(high >= low) { //search array until there is a single element left
    int mid = (low + high) / 2; //mark middle index
    if (key < list[mid]) //if key is smaller than the middle element..
      high = mid - 1;  //new high is the middle element
    else if (key == list[mid]) //if key=middle element --> voila!
      return mid; //returns the index of searched element if it is in your array
    else
      low = mid + 1; //if key is greater than the middle element new low is middle element
  }
  return –low - 1;  //high < low, key not found
}