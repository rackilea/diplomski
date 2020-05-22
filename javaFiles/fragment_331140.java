public class MyArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i, j;
        Integer[][] a = new Integer[3][3];
        for (i = 0; i <= 2; i++)
            for (j = 0; j <= 2; j++) {
                System.out.print("input a" + i + j);
                a[i][j] = in.nextInt();
            }
        // left(a);
        for (Integer[] item : a) {
            Arrays.sort(item, Collections.reverseOrder());
        }

        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println("");
        }
    }
}