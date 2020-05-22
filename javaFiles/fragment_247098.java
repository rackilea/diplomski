public boolean isHorizontalSpaceFree(final int aRow, final int aCol, final String word) {
    // Asserts that the word will fit in the remaining cells
    if(aCol + word.length() > NUMBER_COLS) {
        return false;
    }
    // Asserts that each cell in the row aRow between aCol and aCol+word.length() are empty
    char[] columns = letterGrid[aRow] // I've assume your grid is made up of chars
    for(int i = aCol; i < aCol + word.length(); i++) {
        if(columns[i] != BLANK_ELEMENT) {
            return false;
        }
    }
    // There is enough remaining blank cells to insert the word
    return true;
}