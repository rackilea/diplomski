public class Main {
    public static class Foo{
        Map<String, Integer> map;
        public Foo(Map<String, Integer> map) {
            this.map = map; // don't create a new object, 
                            // use one that already exists that can be passed as an argument
        }

        public void put(String key, Integer value) {
            map.put(key, value);
        }

        public Integer get(String key) {
            return map.get(key);
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> someMap = new HashMap<>();
        someMap.put("aKey", 42);

        Foo foo = new Foo(someMap); // the Foo object now references the map you just created
        System.out.println(foo.get("aKey")); // prints 42
    }
}