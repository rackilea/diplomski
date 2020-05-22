public class testprog {
    static void f (int x) {
        System.out.println ("num is " + (x+0)); // <- STEP INTO
    }

    static void g (int x) {
->      f(x); //
        f(1); // <----------------------------------- STEP OVER
    }

    public static void main (String args[]) {
        g(2);
        g(3); // <----------------------------------- STEP OUT OF
    }
}