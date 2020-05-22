public class Sandbox {

    public static void main(String[] args) {
        System.out.println(divideTwoStrings("5.5", "7"));
    }

    public static String divideTwoStrings(String string1, String string2) {
        return String.valueOf(Double.valueOf(string1) / Double.valueOf(string2));
    }
}