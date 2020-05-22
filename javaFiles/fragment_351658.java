import java.util.Scanner;
public class Test {
    public static void main(String... args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext())
            System.out.println(Integer.parseInt(s.next(), 16));
    }
}