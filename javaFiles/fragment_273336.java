public class TestC {

    public static void main(String[] args) {
        Boolean[] bits = { Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
                Boolean.FALSE };
        Boolean[] bits1 = { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE };
        Boolean[] bits2 = { Boolean.FALSE, Boolean.TRUE, Boolean.FALSE };
        System.out.println(isPalindrome(bits));
        System.out.println(isPalindrome(bits1));
        System.out.println(isPalindrome(bits2));

    }

    public static Boolean isPalindrome(Boolean[] bits) {
        Boolean result = true;
        for (int i = 0; i < bits.length; i++) {
            Boolean a = bits[i];
            Boolean b = bits[bits.length - i - 1];
            if (a != b)
                result = false;
        }
        return result;
    }
}