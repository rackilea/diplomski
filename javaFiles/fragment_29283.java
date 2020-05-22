public class AToBMapper {
    public static A fromB(B b) {
        A a = new A();
        a.setA(b.getA());
        a.setB(b.getB());
        return a;
    }

    public static B fromA(A a) {
        //fill in
    }
}