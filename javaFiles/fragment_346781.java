public static int[] choose(int[] array, int count, Random rand) {
    int[] ar = array.clone();
    int[] out = new int[count];
    int max = ar.length;
    for (int i = 0; i<count; i++) {
        int r = rand.nextInt(max); 
        //max is decremented, 
        //the selected value is copied out then overwritten 
        //by the last value, which would no longer be accessible
        max--;
        out[i]=ar[r];
        ar[r]=ar[max];
    }
    return out;
}