int A[][] = new int[][]{{1,2,3},
                            {4,5,6},
                            {7,8,9}};
    int B[][] = new int[][]{{1,2,3,10},
                            {4,5,6,11},
                            {7,8,9,12},
                            {1,2,3,13}};

    System.out.println("====================");
    int number = 1;
    for(int rowIndex = A.length - 2; rowIndex < A.length; rowIndex++) {
        for(int colIndex = A[0].length - 2; colIndex < A[0].length; colIndex++) {
            number *= A[rowIndex][colIndex];
            System.out.print(A[rowIndex][colIndex] + "\t");
        }
        System.out.print("\n");
    }
    System.out.println("====================");     
    for(int rowIndex = 0; rowIndex < 2; rowIndex++) {
        for(int colIndex = 0; colIndex < 2; colIndex++) {
            number *= B[rowIndex][colIndex];
            System.out.print(B[rowIndex][colIndex] + "\t");
        }
        System.out.print("\n");
    }
    System.out.println("====================");
    System.out.print("ANSWER IS: " + number);