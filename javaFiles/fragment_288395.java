public class Temp {

    public static interface I1 {
        public void interfaceFn1();
        public void interfaceFn2();
    }

    public static abstract class A implements I1 {
        int a;
        public void foo(){
            System.out.printf("%s In A a=%d\n", this, a);
        }

        @Override public void interfaceFn1() {
            System.out.println("In A.interfaceFn1");
        }
    }

    public static class AA extends A {
        int aa;

        @Override 
        public void foo(){
            super.foo();
            System.out.printf("%s In AA a=%d, aa=%d\n", this, a , aa);
        }

        @Override public void interfaceFn2() {
            System.out.println("In A.interfaceFn1");
        }
    }
}