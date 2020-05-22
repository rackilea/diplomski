public Double[][] convertToDoubleArray(){
    int i;
    int j;
    doubleArray = new Double[rows][columns];

    for(i = 0; i < rows; i++){ // iterate through row
        for(j = 0; j < columns; j++){ // iterate through column
            doubleArray[i][j] = Double.parseDouble(stringArray[i][j]); // cast each string value to 
        }
    }
    return doubleArray;
}