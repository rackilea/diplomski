for (int row = 0; row < (mainArray.length); row += 2) {
        for (int column = 0; column < mainArray[0].length; column+=2) {
            subArray[0][0] = mainArray[row][column];
            subArray[0][1] = mainArray[row][column + 1];
            subArray[1][0] = mainArray[row + 1][column];
            subArray[1][1] = mainArray[row + 1][column + 1];
            //column += 2;
            System.out.print(subArray[0][0] + " " + subArray[0][1] + "\n"
                    + subArray[1][0] + " " + subArray[1][1] + "\n");
        }
    }