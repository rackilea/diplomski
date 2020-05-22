/**
 * Using Integer/String classes functionality
 */
public class Shweta {

    private static Integer i = 185;

    public static void main(String... args) {
        String iStr = i.toString();
        for (char digit : iStr.toCharArray()) {
            System.out.println(digit);
        }
        System.out.println("Length is: " + iStr.length());
    }

}