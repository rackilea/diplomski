class A {}
class B extends A {}
class C extends A {}


public class SOSample {
    public static void main(String[] args) {
        List<List<? extends A>> list = new ArrayList<List<? extends A>>();
        final List<? extends A> as = list.get(0);
        as.add(new B()); // error here
    }
}