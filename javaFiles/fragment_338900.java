for(int i = 0; i < 10; i++) {
        int jSum = 0;
        for(int j = 0; j < 10; j++) {
            jSum += grid[i][j];
            System.out.print("1.");
            System.out.printf("%5d ", grid[i][j]);
        }
        System.out.printf(" %5d", jSum);
        System.out.println();
    }