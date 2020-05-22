public static int countCellsToFill(int[][] arr){
    int count=0;
    for(int[] r : arr){
        for(int a: r){
            if(a == 0){
                count++;
            }
        }
    }
    return count;
}