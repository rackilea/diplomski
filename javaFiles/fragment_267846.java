public class SudokuSolver {
  public static void initializeGrid(int[][] grid, int[][] puzzle) {
   for (int r = 0; r < puzzle.length; r++) {
     for (int c = 0; c < puzzle[0].length; c++) {
       grid [r][c] = puzzle [r][c];
     }
   } 
  }

  public static void displayDigits(int r, int c, int[][] grid) {
    if (grid[r][c] == 0) {
      System.out.print('0');
    } else {
      System.out.print(grid[r][c]);
    }
  }

  public static void displayGrid(int[][] grid) {
    for (int r = 0; r < grid.length; r++) {
      if (r % 3 == 0) {
        System.out.println("+---+---+---+");
      }
      for (int c = 0; c < grid[r].length; c++) {
        if (c % 3 == 0) {
          System.out.print("|");
        }
      displayDigits(r, c, grid);
      }
      System.out.print("|");
      System.out.println();
    }
    System.out.println("+---+---+---+");
  }

  public static int getEmptyCells(int[][] grid, int[][] emptyCells) {
    int i = 0;
    int numEmptyCells = 0;
    for (int r = 0; r < grid.length; r++) {
       for (int c = 0; c < grid[r].length; c++) {
         if (grid[r][c] == 0) {
           emptyCells[i][0] = r;
           emptyCells[i][1] = c;
           numEmptyCells++;
           i++;
         }
       }
    }
    return numEmptyCells;
  }

  private static boolean hasNoDuplicates(int[] digitsList) {
    for (int j = 0; j < digitsList.length; j++) {
      for (int k = j + 1; k < digitsList.length; k++) {
        if (digitsList[j] == digitsList[k] && digitsList[j] != 0)
          return false;
      }
    }
    return true;
  }

  private static boolean checkCurrentRow(int[][] grid, int currentRow) {
    int[] digitsList = new int[grid.length];
    for (int c = 0; c < digitsList.length; c++) {
      digitsList[c] = grid[currentRow][c];
    }
    if (hasNoDuplicates(digitsList)) {
      return true;
    }
    return false;
  }

  private static boolean checkCurrentCol(int[][] grid, int currentCol) {
    int[] digitsList = new int[grid.length];
    for (int i = 0; i < digitsList.length;  i++) {
      digitsList[i] = grid[i][currentCol];
    }
    if (hasNoDuplicates(digitsList)) {
      return true;
    }
    return false;
  }

  private static boolean checkCurrentRegion(int[][] grid, int currentRow, int currentCol) {
    int[] digitsList = new int[grid.length];
    currentRow = (currentRow / 3) * 3;
    currentCol = (currentCol / 3) * 3;
    int i = 0;
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        digitsList[i] = grid[currentRow + r][currentCol + c];
        i++;
      }
    }
    if (hasNoDuplicates(digitsList)) {
      return true;
    }
    return false;
  }

  public static boolean isConsistent(int[][] grid, int currentRow, int currentCol) {
    boolean checkRow = checkCurrentRow(grid, currentRow);
    boolean checkCol = checkCurrentCol(grid, currentCol);
    boolean checkReg = checkCurrentRegion(grid, currentRow, currentCol);
    System.out.println("r: " + checkRow + " c: " + checkCol + " r: " + checkReg);
    if (checkRow && checkCol && checkReg) {
      return true;
    }
    return false;
  }

  public static boolean solvePuzzle(int[][] grid, int[][] emptyCells, int numEmptyCells) {
    int i = 0;
    int currentCellDigit = 0;
    while (i < numEmptyCells) {
      if (currentCellDigit != 9) {
        // increment cell value
        currentCellDigit++;
        // assign to current cell the current cell value
        //<var> = currentCellDigit;
        System.out.println("Solving---------------------- :" + currentCellDigit + " R: " + emptyCells[i][0] + " C: " + emptyCells[i][1]);
        // check if value is valid
        if (isConsistent(grid, emptyCells[i][0], emptyCells[i][1])) {
          // reset after setting
          i++;
          currentCellDigit = 0;
        } else {
          // reset cell to zero instead of decrementing it since we're backtracking!
          //grid[emptyCells[i][0]][emptyCells[i][1]] = currentCellDigit - 1;
          //<var> = 0;
        }
      } else {
        // reset current cell to 0
        //<var> = 0;
        // go to previous cell
        i--;
        // exit if theres no cell to backtrack to
        if (i < 0) {
          return false;
        }
        // set previous' cell value as current cell value
        //<var> = grid[emptyCells[i][0]][emptyCells[i][1]];
      }
    }
    return true;
  }

  public static void main(String[] args) {
    final int SIZE = 9;
    int[][] puzzle  = { {0,2,9,0,0,3,0,0,5},
                        {5,0,7,0,0,0,0,9,0},
                        {6,0,0,0,0,9,4,2,0},
                        {3,0,2,0,0,4,0,0,0},
                        {0,0,5,0,3,0,7,0,0},
                        {0,0,0,5,0,0,6,0,2},
                        {0,9,8,4,0,0,0,0,3},
                        {0,3,0,0,0,0,1,0,6},
                        {2,0,0,3,0,0,9,4,0}
                    };

    int[][] grid = new int[SIZE][SIZE];
    int[][] emptyCellsList = new int[SIZE*SIZE][2];
    int numEmptyCells = 0;

    initializeGrid(grid, puzzle);
    numEmptyCells = getEmptyCells(grid, emptyCellsList);
    System.out.println("The puzzle:");  
    displayGrid(puzzle);
    if (solvePuzzle(grid, emptyCellsList, numEmptyCells)) {
      System.out.println("has been solved:");
      displayGrid(grid);
    } else {
      System.out.println("cannot be solved!");
    }
  }
}