public static int[] reverse(int[]ar) 
{
    for (int i = 0; i < ar.length / 2; i++) {
        int temp = ar[i];
        ar[i] = ar[(ar.length-i-1)];
        ar[(ar.length-i-1)] = temp;
    }
    return ar;
}