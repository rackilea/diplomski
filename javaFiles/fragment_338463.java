public int getNumber(int row, int column) {  
    if (row >= matrix.length || column >= matrix[0].length) {
        throw new IndexOutOfBoundsException("("+row+", "+column+") is not a valid pair of indexes.");
    } 
    return data[row][column];
}