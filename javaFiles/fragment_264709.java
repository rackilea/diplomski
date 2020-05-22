public class Test {
    public static List test(Object obj) { // generic types => erasure = raw types
        ArrayList ts = new ArrayList();
        ts.add(obj); // No cast: List.add has erasure (Ljava.lang.Object;)V
        return ts;
    }

    public static Object test2(Object obj) { // T is unbounded => erasure = Object
        return obj; // No cast: all types <: Object
    }

    public static List test3(Object obj) {
        ArrayList ts = new ArrayList();
        ts.add(test2(obj)); // Note: we don't know what T is, so we can't cast to it and ensure test2 returned one.
        return ts;
    }


    public static void main(String[] args) {
        List x = test(1); // Returns a list and doesn't error
        System.out.println(x);

        Double y = (Double) test2(1); // Errors in java as an Integer cannot be converted into a Double
        // This is because the compiler needs to insert casts to make generics work
        System.out.println(y);

        List z = test3(1);
        // Unlike y, there isn't a cast in test3 because test3 doesn't know what T is, so the Integer passes through, uncast, into a List<Double>.
        // The JVM can't detect this, because it doesn't even know what a List<Double> is.
        System.out.println(z);
    }
}