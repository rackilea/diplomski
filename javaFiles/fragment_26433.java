public class TestReplacement {

    public static void main (String [] args) {

        String str = "(111) 111-11-11";

        System.out.println("String before replacement: " + str);

        str = str.replaceAll("\\D", ""); // Replace all non-digits

        System.out.println("String after replacement: " + str);
    }
}