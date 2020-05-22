public static int[] descending(int[] b){

    int temp;

    for(int i = 0; i < b.length - 1; i++){
        for(int j = 0; j < b.length -1; j++){   
            if(b[j] < b[j+1]){
                temp = b[j];
                // both of these calls CHANGE the array
                b[j] = b[j+1];                     
                b[j+1] = temp;
            }
        }
    }

    return(b);
}