int[] a = new int[]{9,2,4,8,9,4,3,2,8,1,2,7,2,5};
// Go through each element of this array:
int n = a.length
for (int i = 0; i < n; i++) {
    // Add 1 to the corresponding position in the count array.
    int position = a[i] - 1;
    count[position]++;
}