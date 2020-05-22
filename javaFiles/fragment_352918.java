public static void deleteRepeats(char[] c, int size){
    int i,j;
    char temp;
    char[] newArray = new char[size];
    for(i=0; i < size; i++){
        newArray[i] = c[i];
    }   
    for(i = 0; i < size; i++){
        for(j = i + 1; j < size; j++){
            if(newArray[i] == newArray[j] && i != j){
                temp = newArray[j];
                for(int k = j; k < size - 1; k++){
                    newArray[k] = newArray[k + 1];
                }
                newArray[size-1] = temp;
            }
        }
    }
    for(i=0;i<size;i++){
        System.out.print(newArray[i]+" ");
    }
}