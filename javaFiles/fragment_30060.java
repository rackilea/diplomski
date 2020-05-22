public class Outer {
    private final int someRandomValue = 4;

    public final Object anonymousInnerInstance = new Object() {
        @Override
        public String toString() {
            // Notice how this class has access to a field declared inside a different
            // class. More specifically, this anonymous class can access someRandomValue,
            // even though someRandomValue belongs to the class, Outer.
            return "Anonymous Inner Class: " + someRandomValue;
        }
    };

    public class RegularInner {
        @Override
        public String toString() {
            // This regular inner class is inside Outer, (just like the anonymous class),
            // and can access any of Outer's fields (amongst Outer's other things).
            return "Regular Inner Class: " + someRandomValue;
        }
    }

    public final RegularInner regularInnerInstance = new RegularInner();

    public static void main(String[] args) {
        Outer outerInstance = new Outer();
        System.out.println(outerInstance.anonymousInnerInstance);
        System.out.println(outerInstance.regularInnerInstance);

        // By the way, you can make new RegularInner instances off of our Outer
        // instance:
        RegularInner newInnerInstance = outerInstance.new RegularInner();
        // When you write "outerInstance.new SomeClass()" you're saying:
        // "I'd like to initialize my 'SomeClass' object with 'outerInstance',
        // as its container." This effectively means that any variables that
        // belong to Outer that your SomeClass needs to access, it will access
        // from the Outer instance you gave it.
    }
}