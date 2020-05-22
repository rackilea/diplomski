for (currentRow = 1; currentRow <= numRows; currentRow++) {
    currentColumnLetter = 'A'; //Starting a new row, reset the column to `A`
    for (currentColumn = 1; currentColumn < numColumns; currentColumn++){
        System.out.print(currentRow); 
        System.out.print(currentColumnLetter + " ");
        currentColumnLetter++;
    }
}