import java.util.Scanner;

public class Temp  {
    static int x;
    static {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
    }
}


class TempA {
    public static void main(String[] args) {
        System.out.println(Temp.x);
    }
}