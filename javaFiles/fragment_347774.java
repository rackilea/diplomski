/* After the prompt code segment and sumOfCol in the main method */

    // Row (major index)
    for (int row = 0; row < matrix.length; row++) {
        int rowSum = 0;
        for (int col = 0; col < matrix[row].length; col++) {
            rowSum += matrix[row][col];
        }
        System.out.println("Sum of the elements at row " + row + " is: " + rowSum);
    }

    // Column (minor index)
    // Assuming the length of each row is the same
    for (int col = 0; col < matrix[0].length; col++) {
        int colSum = 0;
        for (int row = 0; row < matrix.length; row++) {
            colSum += matrix[row][col];
        }
        System.out.println("Sum of the elements at col " + col + " is: " + colSum);
    }