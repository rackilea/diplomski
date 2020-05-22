final int[][] a2dArr = new int[3][3];
System.out.println("Before: " + Arrays.deepToString(a2dArr));
for (int i = 0; i < a2dArr.length; i++) {
      Arrays.fill(a2dArr[i], 0, 1, -21);
}
 System.out.println("After: " + Arrays.deepToString(a2dArr));