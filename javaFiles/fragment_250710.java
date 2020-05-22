int[] arr = { 5, 3, 7, 2 };
System.out.println(Arrays.toString(arr));
for (int i = 0; i < arr.length / 2; i++) {
  int t = arr[i];
  arr[i] = arr[arr.length - i - 1];
  arr[arr.length - i - 1] = t;
}
System.out.println(Arrays.toString(arr));