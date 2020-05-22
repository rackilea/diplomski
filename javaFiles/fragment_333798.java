final int size = 5;
    int[][] result = new int[size][size];

    //the logic
    int counter = 1;
    for(int i = 0; i < size; i++) {
        for(int k = 0; k < size; k++) {
            result[i][(k+i)%size] = counter++;
        }
    }

    //just the output
    for(int i = 0; i < size; i++) {
        boolean isFirst = true;
        for(int k = 0; k < size; k++) {
            if(isFirst)
                isFirst = false;
            else
                System.out.print(", ");
            System.out.print(result[i][k]);
        }
        System.out.println();
    }