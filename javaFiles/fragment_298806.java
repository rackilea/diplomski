int numRows = 0;
    for (i=0; i<8; i++) {
        fiveCount = 0;
        lowCount = 0;

        for (j=0; j<5; j++) {
            if (A[i][j] <= 5) fiveCount++;
            if (A[i][j] == -1)  lowCount++;
        }

        if (fiveCount == 5 && lowCount == 0) {
            System.out.print((i+1) + " ");
            numRows++;
        }
    }
    System.out.println();
    System.out.println("Count of the positive results " + numRows);