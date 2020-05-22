import java.util.BitSet;
import java.util.List;

class SudokuCell {
    BitSet possibilities;
    CellValue value;

    SudokuCell() {

        // Initially the value of this cell is undefined
        value = CellValue.Undefined;

        possibilities = new BitSet(9);
        // Initially every value is possible
        possibilities.set(0, 9);
    }

    // clears the possibility of 'number' from this cell
    void clear(int number) {
        possibilities.clear(number - 1);
        // If there is only one possibility left
        if (possibilities.cardinality() == 1) {

            // Set value of the cell to that possibility
            int intValue = possibilities.nextSetBit(0);
            value = CellValue.fromInteger(intValue);
        }
    }

    // returns the value of this square if it is defined
    int getValue() throws Exception {
        if (value == CellValue.Undefined) {
            throw new Exception("Undefined cell value");
        }
        return CellValue.toInteger(value);
    }

    // returns whether 'num' is still possible in this cell
    boolean isPossible(int num) {
        return possibilities.get(num-1);
    }
}

public class SudokuBoard {
    SudokuCell[][] sudokuBoard;

    // constructor
    SudokuBoard() {
        sudokuBoard = new SudokuCell[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                sudokuBoard[row][col] = new SudokuCell();
            }
        }

    }

    // eliminate the possibility of 'num' from row 'row'
    // skipping columns in List skipCols
    void eliminateInRow(int row, int num, List<Integer> skipCols) {
        for (int col = 0; col < 9; col++) {
            if (!skipCols.contains(col)) {
                sudokuBoard[row][col].clear(num);
            }
        }

    }

}