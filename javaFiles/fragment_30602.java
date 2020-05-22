public class Main {
    static void print(String title, int[][] array) {
        System.out.println(title);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int m = s1.nextInt();
        int n = s1.nextInt();
        System.out.println();
        int[][] array = new int[m][n];
        int[][] ar = new int[n][m];
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                array[i][j] = s1.nextInt();
            }
        }

        print("INPUT ARRAY :", array);

        /* here is the main actions with the array begin*/
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                ar[j][m - i - 1] = array[i][j];
            }
        }

        /*the end of actions with the array*/
        print("TASK ARRAY :", ar);
    }
}