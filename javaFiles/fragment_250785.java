int [][] twoD = new int [5][5];

// populate array with data
for(int i = 0; i<5; i++){
    for(int j = 0; j<5; j++){
        twoD[i][j] = (j+1)*(i+1);
    }
}

// print result
for(int i = 0; i<5; i++){
    for(int j = 0; j<5; j++){
        System.out.print(twoD[i][j]);
        System.out.print(" ");
    }            
    System.out.println();
}