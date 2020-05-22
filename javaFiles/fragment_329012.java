public static void main(String[] args) {
        int[][] matrix = {
            {2, 3, 4, 5, 6, 7, 8, 9}, // 8 elements
            {2, 1, 4, 5, 7, 2, 86}    // 7 elements
        };
        int[] sum = rowSum(matrix);
        for (int i : sum) {
            System.out.println(i);
        }
    }

    public static int[] rowSum(int[][] matrix) //find sum of digits in given row
    {
        int[] sum = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum[i] = sum[i] + matrix[i][j];
            }
        }
        return sum;
    }