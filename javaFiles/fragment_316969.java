private static void merge(int[] result, int[] left, int[] right){
    int i1 = 0; //left index.
    int i2 = 0; //right index.

    for(int i=0; i<result.length; i++){
        if(i1 < left.length && i2 < right.length){
            if(left[i1] <= right[i2]){
                result[i] = left[i1];
                i1++;
            }
            else{
                result[i] = right[i2];
                i2++;
            }
        }
        else if(i1 < left.length){
            result[i] = left[i1];
            i1++;
        }
        else{
            result[i] = right[i2];
            i2++;
        }
    }
}