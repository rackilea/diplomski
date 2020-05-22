private static int resolveR(int i, int max, int pivot, int[] arr){
  //initialize
  if (i == arr.length){
    return max;
  } else {
    pivot = Math.max(0, arr[i] + pivot);
    if (pivot >= max){
        max = pivot;
    }
    return resolveR(i+1, max, pivot, arr);
  }
}