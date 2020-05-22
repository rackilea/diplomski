int[][] array = { { 1, 2, 3, 4, 5, 6 },
            { 7, 6, 8, 3 }, 
            { 1, 2, 3, 4 },
            { 1, 2, 3, 9, 5, 6, 32, 3125423 },
            { 8, 3 }, 
            { 1, 2, 3, 4, 5, 6 } };//same as first row
    external: for (int i = 0; i < array.length; i++) {
        for (int j = i + 1; j < array.length; j++) {
            if (Arrays.equals(array[i], array[j])) {
                System.out.println("Row: " + i + " is the same as row: " + j+" (warning! 0 oriented!)" );
                break external;
            }
        }
    }