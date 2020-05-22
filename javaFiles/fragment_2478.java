public static int[] reverseArrayWithoutTempArray(int[] a) {
    int i = 0;
    int  j = a.length - 1;
    for (i = 0; i < a.length / 2; i++, j--){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
      }
    return a;
}