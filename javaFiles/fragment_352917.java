public static void deleteRepeats2(char[] c, int size){
    int i, j, k = 0;
    char[] newArray = new char[size];

    for(i=0; i < size; i++){
        for(j = 0; j < i; j++){
            if (c[j] == c[i]) 
                break;
        }

        if (j == i)
            newArray[k++] = c[i];
    }

    for(i=0; i < k; i++){
        System.out.print(newArray[i]+" ");
    }
}