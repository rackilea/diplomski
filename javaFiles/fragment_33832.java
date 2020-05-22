public static String printChar2DArray(char[][] arr){
    for (int x = 0; x < arr.length; x++) {
        for (int y = 0; y < arr[x].length; y++) {
            // just a print so it does not make new lines for every char
            System.out.print(arr[x][y]);
        }
    }
    return null;
}