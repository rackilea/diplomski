//Author : Mayank Rajoria
import java.util.*;

class remainderAndQuotient {
    public static void main(String[] args) {
        int n, q, a, k = 1, r;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 numbers");
        n = sc.nextInt();
        a = sc.nextInt();
        r = n % a;
        q = n / a;
        System.out.println("Quotient : " + q);
        System.out.println("Remainder : " + r);
    }
}