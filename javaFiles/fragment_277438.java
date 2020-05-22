public int binarySearch(Integer[] targetArray, int targetValue, int lowIndex, int highIndex){
    if (lowIndex > highIndex)
      return -1;
    int midIndex = lowIndex + (highIndex - lowIndex)/2;
    if (targetValue == targetArray[midIndex])
      return midIndex;
    if(targetArray[midIndex] > targetValue)
      return binarySearch(targetArray, targetValue, lowIndex, midIndex - 1);
    else //if(targetArray[midIndex] < targetValue)
      return binarySearch(targetArray, targetValue, midIndex + 1, highIndex);
    //return -1; // replace this with your recursive binary search code
  }