public class Main {
    public static void main(String[] args) {
        // Tests
        System.out.println(checkPostcode("1234AB"));
        System.out.println(checkPostcode("5678MN"));
        System.out.println(checkPostcode("0123AB"));
        System.out.println(checkPostcode("1023AB"));
        System.out.println(checkPostcode("1230AB"));
        System.out.println(checkPostcode("AB1234"));
        System.out.println(checkPostcode("123456"));
        System.out.println(checkPostcode("ABCDEF"));
        System.out.println(checkPostcode("12345A"));
        System.out.println(checkPostcode("A12345"));
        System.out.println(checkPostcode("A12345B"));
        System.out.println(checkPostcode("1ABCDE6"));
        System.out.println(checkPostcode("1ABCD6"));
    }

    public static boolean checkPostcode(String postCode) {
        return postCode.matches("[1-9]{1}[0-9]{3}[a-zA-Z]{2}");
    }
}