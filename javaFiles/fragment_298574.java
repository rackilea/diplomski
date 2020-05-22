public class Test {
    public Map<String, String> dummy;
    public static void main(String... args) throws SecurityException, 
                                                   NoSuchFieldException {
        Type mapStringString = Test.class.getField("dummy").getGenericType();
        // ...