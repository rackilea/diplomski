public class Main {
    public static void main(String[] args) {
        int n = 5;
        int x = 5;
        String space=" ";
        for (int i = n; i >= 1; i--) {
            for(int j=1;j<(n-i)*3;j++)
                System.out.print(space);
            for (int k = 1; k <= i; k++) {
                System.out.print(x+space);
                x += 5;
            }
            System.out.println();
        }
    }
}