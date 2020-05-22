public class C {
    static C obj; // stores a "partially constructed" object
    C() {
        C.obj = this;
        throw new RuntimeException();
    }
    public static void main(String[] args) {
        C obj;
        try {
            obj = new C();
        } catch (RuntimeException e) {
            /* ignore */
        }
        System.out.println(C.obj);
    }
}