int[] selectionSort(int[] arr) {
    int minIndex;
    for (int i=0;i<arr.length;i++) {
       minIndex= i;
       for (int j=i+1;j<arr.length;j++) {
          if (arr[minIndex]>arr[j])
             minIndex = j;
       }
       swap(arr,i,j);
    }
}