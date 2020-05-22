int[] arr = { 5, 3, 7, 2 };
System.out.println(Arrays.toString(arr));
int[] arr2 = new int[arr.length];
for (int i = 0; i < arr.length; i++) {
  arr2[arr2.length - i - 1] = arr[i];
}
System.out.println(Arrays.toString(arr2));