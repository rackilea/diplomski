public class Main {
    public static void main(String[] args) {
        int n = 5;
        int x = 5;

        for (int i = n; i >= 1; i--) {
            for(int j=1;j<n-i+1;j++)
                System.out.printf("%3s"," ");
            for (int k = 1; k <= i; k++) {
                System.out.printf("%3d",x);
                x += 5;
            }
            System.out.println();
        }
    }
}