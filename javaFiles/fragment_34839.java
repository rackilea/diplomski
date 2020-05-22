public static void evaluateF3(int[] anArray) {
  int[] array2 = new int[anArray.length/2]; 
  for(int i = 0, j= array2.length; j<anArray.length;i++, j++) {
    array2[i]= anArray[j];
    System.out.print(" "+ array2[i]);
  }
}

int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
evaluateF3(a); // 5 6 7 8
int[] a = { 0, 1, 1, 0, 0, 0, 2, 2 };
evaluateF3(a); // 0 0 2 2