int[] array2 = new int[array.length / 3];
int k = 2;
for(int j = 0; j < array2.length; j++) {
    array2[j] = array[k];
    k += 3;
}