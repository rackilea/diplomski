public static void printMatrix(int num) {
    int n = 1;
    int[][] matrix = new int[num][num];
    for (int top = 0, bottom = num - 1; top <= bottom; top++, bottom--) {
        for (int i = 0; i < num; i++) {
            matrix[top][i] = n++;
        }
        if (top == bottom) {
            break;
        }
        for (int i = 0; i < num; i++) {
            matrix[bottom][i] = n++;
        }
    }
    for (int[] arr : matrix) {
        System.out.println(Arrays.toString(arr));
    }
}