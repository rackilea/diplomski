int[][] arr = new int[x][];
arr[1] = new int[arr.length];
int i = 0;
for(String s : arr) {
   arr[1][i] = Integer.valueof(s);
   i++;
}