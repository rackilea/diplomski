...

    for(int i = 0; i < queen; i++){

        int[][] neighborBoard = new int[queen][queen];

        // Here you are setting a reference, not copying the values
        HashMap<Integer, Integer> neighborQueenLocations = initialQueenLocations;

    ...