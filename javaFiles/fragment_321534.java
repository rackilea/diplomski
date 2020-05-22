public class Example {
    interface A { public void show(); }
    interface B { public void show(); }

    class C implements A, B {
        public void show() { System.out.println("show()ing"); }
    }

    public static void main(String[] args) {
        C c = new C();

        A a = c;
        a.show();  // does something, trust me :P

        B b = c;
        b.show();  // does something too
    }
}