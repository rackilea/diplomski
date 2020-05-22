int n,m;
    n = 2;
    m = 3;
    int number = 0;
    int matrix1[][]=new int[n][m];
    int matrix2[][]=new int[n][m]; 

    //Fill the array one
    for (int i = 0; i < matrix1.length; i++) {
        for (int j = 0; j < matrix1.length; j++) {
            matrix1[i][j] = (int)(10 * Math.random());
        }
    }

    //Print out first array
    for (int i = 0; i < matrix1.length; i++) {
        for (int j = 0; j < matrix1.length; j++) {
            System.out.print(matrix1[i][j] +  "  " );
        }
    }

    //Populate second array with numbers in first array
    for (int i = 0; i < matrix1.length; i++) {
        for (int j = 0; j < matrix1.length; j++) {
            matrix2[i][j] = matrix1[i][j] * matrix1[i][j];

        }
    }


    System.out.println("Second array: ");

    for (int i = 0; i < matrix1.length; i++) {
        for (int j = 0; j < matrix1.length; j++) {
            System.out.print(matrix2[i][j] +  "  " );
        }
    }