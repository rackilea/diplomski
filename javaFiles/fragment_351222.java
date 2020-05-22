int [] a = twoDimArray[twoDimArray.length - 1];
 Arrays.sort(a);
 //Swap
 for (int i = 0, j = a.length - 1, tmp; i < j; i++, j--) {
    tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
  System.out.println(Arrays.toString(twoDimArray[twoDimArray.length - 1]));