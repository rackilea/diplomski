public static void setThreeNumbers(int[][] arr) {
    if (arr.length > 0 && arr[0].length > 0) {
        arr[0][0] = 42;
        if(arr.length > 2 && arr[0].length > 2) {
            arr[2][2] = -2;
            if(arr.length > 3 && arr[0].length > 5) {
                arr[3][5] = -3;
            }
        }
    }   
}