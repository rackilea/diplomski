public class SomeClass {
    private static int static_member;
    private int instance_member;

    public void instance_method() {
        // this is completely different from the other
        // local_variable in static_method()
        int local_variable;

        static_member = 1; // legal
        SomeClass.static_member = 1; // legal
        instance_member = 1 // legal
        this.instance_member = 1 // legal
    }

    public static void static_method() {
        // this is completely different from the other
        // local_variable in instance_method()
        int local_variable;

        static_member = 1; // legal
        SomeClass.static_member = 1; // legal
        instance_member = 1 // not legal, in a static method, there is no instance
    }
}