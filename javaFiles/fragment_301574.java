public void printLine(int amountOfCharacters) {
    StringBuilder lineNumber = new StringBuilder();
    StringBuilder lineScaleSymbols = new StringBuilder();
    for (int i = 0; i < amountOfCharacters; i++) {
        if (i % 10 == 0) {
            if (i < 10) {
                lineNumber.append(i);
            } else {
                lineNumber.insert(i -1, i);
            }
            lineScaleSymbols.append('|');
        } else if (i % 5 == 0) {
            if (i < 10) {
                lineNumber.append(i);
            } else {
                lineNumber.insert(i -1, i);
            }
            lineScaleSymbols.append('+');
        } else {
            lineNumber.append(' ');
            lineScaleSymbols.append('-');
        }
    }

    System.out.println(lineNumber.toString());
    System.out.println(lineScaleSymbols.toString());
}