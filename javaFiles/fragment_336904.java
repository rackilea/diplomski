static int[][] revTriangle(int lines) {
    int[][] arr = new int[lines][];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = new int[lines - i]; // this line
    }
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            arr[i][j] = count++;
        }
    }

    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            System.out.print(arr[i][j] + " ");
        }
        System.out.println();
    }
    return arr;
}