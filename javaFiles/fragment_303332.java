public class A {
    private int a = 10;

    public void m1() {
        int m = 15;

        class B {
            private int b = 20;

            void m2() {
                int x = 25;
                System.out.println(x);  // x = 25
                System.out.println(a);  // a = 10
                System.out.println(b);  // b = 20
                System.out.println(m);  // m = 15
            }
        }
    }
}