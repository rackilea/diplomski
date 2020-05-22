public class Test {
    public static void main(String... args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        put(map, "/a/b/c/d1", 20);
        put(map, "/a/b/c/d2", 30);
        put(map, "/a/b/c", 50);
        put(map, "/a/b/x", 40);
        System.out.println("/a/b/c: " + map.get("/a/b/c"));
        System.out.println("/a/b: " + map.get("/a/b"));
    }
    static void put(HashMap<String, Integer> map, String path, int value) {
        String p = "";
        for(String e : path.split("/")) {
            if (e.length() > 0) {
                p += "/" + e;
                Integer old = map.get(p);
                map.put(p, (old == null ? 0 : old) + value);
            }
        }
    }
}