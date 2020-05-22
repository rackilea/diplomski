public String toString() {

    StringBuilder sb = new StringBuilder(64);

    for (int row = 0; row < (magicSquare.length); row++) {
        // row gets #row
        sb.append("\t");
        for (int column = 0; column < (magicSquare[row].length); column++) {
            //column gets #column 
            sb.append(magicSquare[row][column] + "\t");

            // when all column has been completed make new line
            if (column == size - 1) {
                sb.append("\n");
            }

        }
        sb.append("\n");

    }

    return sb.toString();
}