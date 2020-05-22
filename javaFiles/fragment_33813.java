public static void main(String[] args) {

        int length = 7;

        int[][] numbers = new int[length][length];

        int count = 1;
        for(int i = 0; i < numbers.length; ++i) {
            for(int j = 0; j < (i+1); ++j) {
                numbers[i][j] = count++;
                if(count > 9)
                    count = 1;
            }
        }

        for(int i = 0; i < numbers.length; ++i) {
            for(int j = 0; j < numbers.length; ++j) {
                if(numbers[j][i] == 0)
                    System.out.print(" ");
                else
                    System.out.print(numbers[j][i]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }