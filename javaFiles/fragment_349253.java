for(int i = 0; i < 4; i++){
    int value = 0;
    for(int j = 0; j < 4; j++){
        value += matrix[i][j] * vec[j]; 
    }
    newV[i] = value;
}