public class Test {
    static List<String> list = new ArrayList<>();

    public static void extraReference() {
        String s = new String();
        list.add(s);
    }

    public static void noReference() {
        list.add(new String());
    }
}