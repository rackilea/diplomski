/**
 * Calculate the digits. The arguments are 0 based.
 * 
 * @param row The row index
 * @param column The column index
 * @return The digit to display
 */
public static int calculateDigit(int row, int column) {
    if (row < 0) {
        throw new IllegalArgumentException("The row index must not be negative");
    }
    if (column < 0) {
        throw new IllegalArgumentException("The column index must not be negative");
    }
    if (column == 0) {
        return (row+1) % 10; // simply return the row number
    }
    if (row == 0) {
        return 1; // in the first row, so it is the "1"
    }
    // calculate the new number based on the expression
    // "adding the number from the left and the number above it"
    int left = calculateDigit(row, column-1);
    int above = calculateDigit(row-1, column-1);
    int sum = left + above;
    int modulo = sum % 10;
    return modulo;
}