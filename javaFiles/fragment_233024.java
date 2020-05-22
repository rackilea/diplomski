public static void main(String... args) throws Exception
{
    //......

    printSudoku(sudokuPuzzle);
    int count = countCellsToFill(sudokuPuzzle);
    System.out.println("Num of zeros: " + count);
}