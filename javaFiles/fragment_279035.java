public static int partition(String[] A, int p, int r) {
   String x = A[r];
   int i = p - 1;
   for (int j = p; j <= r - 1; j++) {
       int comparison = A[j].compareTo(x);
       if (comparison <= 0) {
           i = i + 1;
           swap(A, i, j);
       }
   }
   swap(A, i + 1, r);
   return i + 1;
}

public static void swap(String[] a, int i, int j) {
   String temp = a[i];
   a[i] = a[j];
   a[j] = temp;    
}