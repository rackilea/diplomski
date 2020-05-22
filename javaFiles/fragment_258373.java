int[] arr = new int[] {1, 2, 2, 3, 5, 5, 8, 2, 4, 8, 8};
int kthSmallest = 6;

int[] distinctArray = getDistinct(arr);
int kthSmallestElement = quickselect(distinctArray, 0, distinctArray.length - 1, kthSmallest - 1);

System.out.println(kthSmallestElement);