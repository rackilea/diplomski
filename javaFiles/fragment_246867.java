public static void main(String[] args) {

        int[][] input = {{3, 2, 1}, {4, 5, 6},{8, 7, 9}};

        int[][] output = new int[9][3];

        for(int i = 0; i < input.length; ++i) {
            for(int j = 0; j < input[i].length; ++j) {
                output[3*i+j][0] = i;
                output[3*i+j][1] = j;
                output[3*i+j][2] = input[i][j];
            }
        }

        for(int i = 0; i < output.length; ++i) {
            for(int j = 0; j < output[i].length; ++j) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }