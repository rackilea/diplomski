public static void loopExample (String[][] someTwoDimArray) {
    // Looping rows
    for (var row = 0 ; row < someTwoDimArray.length ; row++) {
        for (var col = 0 ; col < someTwoDimArray[0].length ; col++) {
           System.out.println(someTwoDimArray[row][col]);
        }
    }

    // looping columns
    for (var col = 0 ; col < someTwoDimArray[0].length ; col++) {
        for (var row = 0 ; row < someTwoDimArray.length ; row++) {
           System.out.println(someTwoDimArray[row][col]);
        }
    }
}