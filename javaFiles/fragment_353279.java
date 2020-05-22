for (int i=0; i<arr.length;  i++) {
   for (int j=1; j<arr.length; j = j*2) {
      if (arr[i] > arr[j])
         sum += arr[i];
   }
}