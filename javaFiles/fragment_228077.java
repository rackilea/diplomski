public class MyClass {

    private static final Map<String, String> map = new HashMap<String, String>(); // Java 6
    private static final Map<String, String> map = new HashMap<>(); // Java 7

    public static void put(String k, String v) {
        synchronized(map) {
            map.put(k, v);
        }
    }

    public static void printAll() {
        synchronized(map) {
            for (Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}