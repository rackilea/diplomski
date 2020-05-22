public static void getMaxVotes(int[][][] votes, String[][] uniStud, int size, int size1, PrintWriter uniWrite) {

    int maxRow = 0;
    int indexOfMaxRow = 0;


    // Get sum of the first row in maxRow
    for (int column = 0; column < votes[size].length; column++) {
        maxRow += votes[size][0][column];
    }
    for (int row = 0; row < votes[size].length; row++) {
        int totalOfThisRow = 0;
        for (int column = 0; column < votes[size][row].length; column++) {
            totalOfThisRow += votes[size][row][column];
        }
        if (totalOfThisRow > maxRow) {
            maxRow = totalOfThisRow;
            indexOfMaxRow = row;
        }
    }
    System.out.println(" has the maximum sum of " + maxRow);
    System.out.println();
}