import java.util.Scanner;
import java.io.*;

public class MyClass {

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(new File("sample.txt"));
        int tmp1 = s.nextInt();
        int tmp2 = s.nextInt();
        System.out.println(tmp1 + tmp2);
    }
}