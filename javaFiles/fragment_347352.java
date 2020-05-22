public static boolean duplicateKDistance(int[] array, int m){

    for (int i=0; i<array.length; i++){
        for(int j=i+1; j<=m; j++){        

            if (array[i] == array[j])
                return true;

        }   
    }
    return false;   
}