int[][] myMatrix = {{4, 2, 2, 1, 0} ,
                        {2, 3, 2, 1, 0},
                        {2, 2, 1, 1, 1},  
                        {1, 1, 2, 1, 0}, 
                        {1, 1, 0, 1, 0}, 
                        {0, 0, 1, 0, 0}  };
    int coordinates[][] = new int[myMatrix.length][2];
    int maximum[] = new int[myMatrix.length];
    int m = Math.min(myMatrix.length, myMatrix[0].length);
    for(int p = 0; p < m; p++){  
        maximum[p] = myMatrix[p][p];
        coordinates[p][0] = p;
        coordinates[p][1] = p;
        for(int j = p; j < myMatrix[p].length; j++){ 
            if(maximum[p] <= myMatrix[p][j]){           
                maximum[p] = myMatrix[p][j];                   
                coordinates[p][0] = p;                     
                coordinates[p][1] = j;
            }
        }
        for(int i = p; i < myMatrix[p].length; i++){  
            if(maximum[p] <= myMatrix[i][p]){            
               maximum[p] = myMatrix[i][p];
               coordinates[p][0] = i;
               coordinates[p][1] = p;
           }
        }