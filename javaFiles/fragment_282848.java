import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        while (true) {
            try {
                if (sc.nextInt() % k == 0) {
                    count++;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
        System.out.println(count);

    }
}