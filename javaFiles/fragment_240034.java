interface SomeInterface {
    void s();
}
class Outer {
    static SomeInterface m() {
        class LocalStatic implements SomeInterface {
            public void s() {
                System.out.println("static local inner class method");
            }
        }
        return new LocalStatic();
    }
}