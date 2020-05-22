int []min = new int[column_lenght];
for(int j = 0; j < column_length; j++) {
    min[j] = array[i][j];
    for(int i = 0; i < row_length; i++) {
        if(array[i][j] < min[j]) {
            min[j] = array[i][j];
        }
    }
}