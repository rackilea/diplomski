for (currentRow = 0; currentRow < numRows; currentRow++) {
    currentColumnLetter = 'A';
    for (currentColumn = 0; currentColumn < numColumns; currentColumn++) {
        System.out.print(currentRow + 1);
        System.out.print(currentColumnLetter + " ");
        currentColumnLetter++;
    }
}