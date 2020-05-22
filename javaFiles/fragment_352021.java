public static int columns(String [][] matrix) {
    int numCol = matrix[0].length;
    int indexCol = -1;
    int countEach = 0; // Put countEach outside the for loop

    for(int col = 0; col < numCol; col++) {
        int count = 0;

        for(String[] row : matrix) {
            count += row[col].length();

            System.out.println("count one by one (rows) : " + count +" "+"Column :" + col);
        }

        // Move if clause to here
        if(count > countEach){
            countEach = count;
            indexCol = col; // Update column index with more chars
        }

        System.out.println("SumChar : " + count +" " + "column : "+col + "###############");
        System.out.println();
    }

    System.out.println("Index of the highest array of characters by columns : ");
    return indexCol;
}