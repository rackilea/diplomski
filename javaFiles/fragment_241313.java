int max= 0;
    for(int i=0; i<col; i++){
        // select first element of a column as temp max
        max= table[0][i];
        for(int j=0; j<row; j++){
            // cycle on rows
            if(max<table[j][i]){
                max= table[j][i];
            }
        }
        System.out.println("Maximum number is "+ max);
        System.out.println();
    }