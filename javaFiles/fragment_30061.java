public class Outer {
    private final int someRandomValue = 4;

    public static final Object anonymousStaticInstance = new Object() {
        @Override
        public String toString() {
            // someRandomValue belongs to an INSTANCE of Outer. (So each Outer object you
            // have has its own someRandomValue). Since this anonymous class
            // is now static, it is no longer tied to an instance of Outer. It doesn't have
            // an Outer object that it can read "someRandomValue" from. The same goes for
            // RegularStatic, below.
            return "Anonymous Inner Class: " + someRandomValue;
        }
    };

    public static class RegularStatic {
        @Override
        public String toString() {
            return "Regular Inner Class: " + someRandomValue;
        }
    }

    public final RegularStatic regularInnerInstance = new RegularStatic();

    public static void main(String[] args) {
        Outer outerInstance = new Outer();
        System.out.println(outerInstance.anonymousStaticInstance);// Java warns you here and
        // tells you to access anonymousStaticInstance statically. This is because
        // anonymousStaticInstance no longer belongs to any given instance of Outer.
        // There is only one anonymousStaticInstance, that "belongs" to the class Outer,
        // rather than multiple anonymousInnerInstances which each belong to an instance
        // of Outer.
        System.out.println(outerInstance.regularInnerInstance);
    }
}