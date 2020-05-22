public static int finding1s (int array[][]){
    int count = 0;
    for (int i = 0; i < array.length; i++){
        for ( int j =0; j < array[i].length; j++){
             if (array[i][j] != 0){
                count++;
            }
        }
    }
    return count;
}

public static void main(String[] args) {
    int[][] array = { { 0, 1, 0, 0 }, { 1, 0, 0, 0 }, { 0, 0, 1, 0 },
            { 1, 1, 0, 1 }, { 1, 1, 1, 1 } };
    System.out.println(finding1s(array));
}