void checkEquality (int arrayA[] , int arrayB[]){
    boolean equals = false;
    for (int x = 0 ;x < 5 ; x++){
        equals = false;
        for (int y = 0 ; y < 5 ; y++){  
            if (arrayA[x] == arrayB[y]){
                equals = true;
                break;
            }
        }
        if (equals == false)
            return false;
    }
}