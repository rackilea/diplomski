class Bar {
    static {
        //Baz.testAsserts();
        boolean enabled = false;
        assert  enabled = false;
        System.out.println("Asserts " + 
               (enabled ? "enabled" : "disabled"));
        // Will execute before Baz is initialized!
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