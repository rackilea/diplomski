import java.util.Scanner;

public class Algorithm {
    public static void main(final String args[]) {

        int i, j, n;
        final Scanner scanner = new Scanner(System.in);
        try {
            String s = scanner.nextLine();
            n = Integer.parseInt(s);
            i = 2;
            while (i <= n) {
                for (j = 1; j <= n / 2; j++) {
                    System.out.println(i + " " + j);
                }
                System.out.println(i + " " + j);
                i = i + 2;
            }
            for (j = 0; j <= i; j += 4) {
                System.out.println(" " + j);
            }
        } finally {
            scanner.close();
        }
    }
}