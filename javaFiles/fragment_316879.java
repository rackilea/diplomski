public class Q1 {
    public static void main(String[] args) {
        Bar b = new Bar();
    }
}
class Bar {
    static {
        boolean enabled = false;
        assert  enabled = false; //line(a)
        System.out.println("Asserts " + 
               (enabled ? "enabled" : "disabled"));
        System.out.println("as");
        Baz.testAsserts();
    }
}
class Baz extends Bar {
    static void testAsserts() {
        boolean enabled = false;
        assert  enabled = false;
        System.out.println("Asserts " + 
               (enabled ? "enabled" : "disabled"));
    }
}