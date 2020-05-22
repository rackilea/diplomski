public static int maxSum(int array[], int low, int high) {
   int maxsum = 0, maxleftsum = 0;
   for (int i = low; i < high; i++) {
       maxsum = max(maxsum, array[i] + maxleftSum);
       maxleftSum = max(0, maxleftSum+array[i]);
   }
   return maxsum; // return the index if necessary. 
}