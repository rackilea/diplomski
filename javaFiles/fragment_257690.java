public static void bubblesort(int[] a) {
  int lastSwap = a.length-1;
  for(int i=1; i<a.length; i++) {
    boolean is_sorted = true;
    int currentSwap = -1;

    for(int j=0; j < lastSwap; j++) {
      if(a[j] > a[j+1]) {
         int temp = a[j];
         a[j] = a[j+1];
         a[j+1] = temp;
         is_sorted = false;
         currentSwap = j;
      }
    }

    if(is_sorted) return;
    lastSwap = currentSwap;
  }
}