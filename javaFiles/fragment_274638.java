public class Test {
    Map map = new HashMap();
    public static void main (String ... args) {
        Test test = new Test();
        test.put("test", "value");
        System.out.println("Test: " + test.get("test", Double.class));
    }

    public Object get(String key, Class clazz) {
        return map.get(key);
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }
}