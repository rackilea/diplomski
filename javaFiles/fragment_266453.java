for (int i = 0; i < numOfRows; i++) {
    for (int j = 0; j < numOfCols; j++) {
        // check all bounds out of range:
        int iMin = Math.max(0, i - 1);
        int iMax = Math.min(numOfRows - 1, i + 1);
        int jMin = Math.max(0, j - 1);
        int jMax = Math.min(numOfCols - 1, j + 1);

        // loop through the above numbers safely
        for (int innerI = iMin; innerI <= iMax; innerI++) {
            for (int innerJ = jMin; innerJ <= jMax; innerJ++) {
                if (i != innerI && j != innerJ) {
                    // do what needs to be done
                }
            }
        }
    }
}