interface A { public void show(); }
interface B { public int show(int); }  <-- different return type!

class C implements A, B {
    public void show() { System.out.println("Showing..."); }
    public int show(int i) { System.out.println(i); }
}