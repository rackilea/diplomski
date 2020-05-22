private static Map<String, String> m = new ConcurrentHashMap<>();

public static void main(String[] args) {
    boolean hasNullKey = false;
    try {
        if (m != null && m.containsKey(null)) {
            hasNullKey = true;
        }
    } catch (NullPointerException npe) {
         // Relies on the fact that you can't add null keys to Map 
         // implementations that will throw when you check for one.
         // Add logging etc.
    }
    System.out.println("Does map have null key? " + hasNullKey);
}