// Row calculation
    int rowSum = 0, maxRowSum = Integer.MIN_VALUE, maxRowIndex = Integer.MIN_VALUE;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            rowSum = rowSum + mat[i][j];
        }
        if (maxRowSum < rowSum) {
            maxRowSum = rowSum;
            maxRowIndex = i;
        }
        rowSum = 0;   // resetting before next iteration
    }

    // Column calculation
    int colSum = 0, maxColSum =  Integer.MIN_VALUE, maxColIndex = Integer.MIN_VALUE;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            colSum = colSum + mat[j][i];
        }
        if (maxColSum < colSum) {
            maxColSum = colSum;
            maxColIndex = i; 
        }
        colSum = 0;    // resetting before next iteration
    }

    System.out.println("Row " + maxRowIndex + " has highest sum = " +maxRowSum);
    System.out.println("Col " + maxColIndex + " has highest sum = " +maxColSum);