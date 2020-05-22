int[][] result = function(parameter);

System.out.println(Arrays.deepToString(result));
for (int row = 0; row < result.length; row++) {     
    for (int col= 0; col< result[0].length; col++) {
        if (result[row][col] >= 179 && result[row][col] <= 204) {
            System.out.print("\\");
        }   
        if (result[row][col] >= 205 && result[row][col] <= 230) {
            System.out.print(".");
        }   
        if (result[row][col] >= 231 && result[row][col] <= 255) {
            System.out.print(" ");
        }
    }
}