import java.io.*;
import java.util.*;

class singinh
{
    void sub(int a, int b)
    {
        int c = a-b;
        System.out.println("Diff is"+c);
    }
}

public class singinh1 extends singinh {
    int a,b;
    void add(int a, int b)
    {
        this.a=a;
        this.b=b;
        System.out.println("Sum is"+a+b);
    }
    public static void main(String args[])
    {
        singinh1 s = new singinh1();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        s. add(a,b);
        s.sub(a,b);
    }
}