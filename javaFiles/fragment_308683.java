private static void merge(int[] result, int[] left, int[] right){
    int i1 = 0; //left index
    int i2 = 0; //right index
    for (int i=0; i<result.length; i++){
        if (i1<left.length && i2<right.length){ //We have something in both lists
            if (left[i1]<=right[i2]){  //Add from left
                result[i] = left[i1];
                i1++;
            }else{ //Add from right
                result[i] = right[i2];
                i2++;
            }
        }
        //If we get to here we know one list is empty
        //We need to figure out which one is empty
        else if (i1<left.length){//Right is empty
            result[i] = left[i1]; //Add from left
            i1++;
        }else{ //Left is empty
            result[i] = right[i2]; //Add from right
            i2++;
        }
    }
}