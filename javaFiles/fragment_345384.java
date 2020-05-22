public class Fibonacci {
    public static void main(String[] args) {
        int n = 15, a = 1, b = 1;
        System.out.print(a + " " + b);
            for(int i =3; i < n; i++) {
            b = a + b;
            a = b - a;
            System.out.print(" " + b);
        }
    }
}