public static int findMax(int[] x) {
  int max = Integer.MIN_VALUE;
  for (int a : x) {
      max = Math.max(max, a);
  }
  return max;
}