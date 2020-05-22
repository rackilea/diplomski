public class UsesWrappersMain {
    public static void main(String... args) {
        for (int j = 0; j < 10; j++) {
            long used = used(), count = 0;
            for (int i = 0; i < 2000; i++) {
                count += printSum();
            }
            // add an object to show it is working
            byte[] b = new byte[16];
            long used2 = used();
            System.out.printf("Memory used for %,d iterations was %,d bytes%n", count, used2 - used);
        }
    }

    private static int printSum() {
        int count = 0;
        for (float i = 0; i < 10000; i++) {
            // definitively not autoboxed.
            Float j = new Float(i);
            count++;
        }
        return count;
    }

    private static long used() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
}