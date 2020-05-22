private static ArrayList<byte[]> transpose(ArrayList<byte[]> arr) {
    ArrayList<byte[]> newArr = new ArrayList<byte[]>(9);

    // fill with null
    for(int i = 0 ; i < 9 ; i++)
        newArr.add(null);

    for(int row = 0; row < 3 ; row++) {
        for(int col = 0 ; col < 3 ; col++) {
            // diagonal
            if(row == col) {
                newArr.add(row + 3*col, arr.get(row + 3*col));
            }

            int second = row + 3*col;       // elem at (row,col)
            int first = 3*row + col;        // elem at (col,row)

            // swap
            newArr.set(first, arr.get(second));
            newArr.set(second, arr.get(first)); 
        }
    }

    return newArr;
}