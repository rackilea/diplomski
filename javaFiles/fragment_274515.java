public static int arrayContainsSum(int[] a, int[] b) {
  final Set<Integer> sums = new HashSet<Integer>();
  for (int i = 0; i < a.length - 1; i++) sums.add(a[i] + a[i+1]);
  for (int x : b) if (sums.contains(x)) return 1;
  return 0;
}