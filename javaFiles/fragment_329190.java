import java.io.IOException;
import java.util.Scanner;

public class Chapter_3_Self_Test {
    public static void main (String args []) throws IOException {
        Scanner sc = new Scanner (System.in);
        int counter = 0;
        for (char a; a == '.'; counter++)   {
            a = (char) System.in.read();
        }
        System.out.println(counter);
    }
}