public static void bubblesort(int[] a) {
  for(int i=1; i<a.length; i++) {
    boolean is_sorted = true;

    for(int j=0; j < a.length - i; j++) { // skip the already sorted largest elements
      if(a[j] > a[j+1]) {
         int temp = a[j];
         a[j] = a[j+1];
         a[j+1] = temp;
         is_sorted = false;
      }
    }

    if(is_sorted) return;
  }
}