int[] array = { 1, 2, 3 }; // <-- your array declaration isn't valid.
// String temp; // <-- A String is not an int.
int x = array.length; // <-- added to demonstrate

for (int i = 0; i < x / 2; i++) {
    // This is a swap with no temporary storage, also known as the
    // http://en.wikipedia.org/wiki/XOR_swap_algorithm
    array[i] ^= array[x - 1 - i];
    array[x - 1 - i] ^= array[i];
    array[i] ^= array[x - 1 - i];
}
System.out.println(Arrays.toString(array));