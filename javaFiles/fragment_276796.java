public boolean backtrack(int currentIndex) {
    if (NoBlankBoxes())
        return true;
    for (int i = 1; i <= 9; ++i) {
        if (NoDuplicates()) {
            puzzle[row][column] = i;
            ++currentIndex;
            if (backtrack(currentIndex) == true) {
                return true;
            }
            puzzle[row][column] = 0;
        }
    }
    return false;
}