private static void drawRow(int i) {
    // Use a StringBuilder, ~30 times faster than String concatenation!
    StringBuilder row = new StringBuilder();
    if(i == currentY) {
        // Create this row differently, as it contains the character.
        for (int x = 0; x < SIZE_X; x++) {
            if(x == currentX) {
                row.append(CHARACTER);
            } else {
                row.append(EMPTY);
            }
        }
    } else {
        // Create an empty row.
        for (int x = 0; x < SIZE_X; x++) {
            row.append(EMPTY);
        }
    }
    // "Draw" the row by printing it to the console.
    System.out.println(row.toString());
}