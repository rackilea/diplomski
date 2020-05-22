Integer[][] arr = new Integer[4][4];
        arr[0][0] = 4;
        arr[0][1] = 3;
        arr[0][2] = 1;
        arr[0][3] = 2;

        arr[1][0] = 6;
        arr[1][1] = 4;
        arr[1][2] = 9;
        arr[1][3] = 2;

        arr[2][0] = 9;
        arr[2][1] = 7;
        arr[2][2] = 5;
        arr[2][3] = 4;

        arr[3][0] = 11;
        arr[3][1] = 33;
        arr[3][2] = 6;
        arr[3][3] = 8;

for (int i = 0; i < arr[0].length; i++) {
    for (int j = i+1; j < arr[0].length; j++) { 
        if (arr[0][i] > arr[0][j]) {    
            for (int k = 0; k < arr.length; k++) {
                int temp = arr[k][i];
                arr[k][i] = arr[k][j];
                arr[k][j] = temp;
            }
        }
    }
 }