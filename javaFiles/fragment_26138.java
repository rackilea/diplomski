public class Program2{

    public static Boolean isPalindrome(String string) {
        if (null == string)
            return false;
        String reverse = new StringBuffer(string).reverse().toString();
        if (string.equals(reverse))
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("String: ");
        String word = s.nextLine();
        while (!word.equals("QUIT")) {
            if (isPalindrome(word)) {
                System.out.println("The string [" + word + "] IS a palindrome.");
            } else {
                System.out.println("The string [" + word + "] IS NOT a palindrome.");
            }
            System.out.println("String: ");
            word = s.nextLine();
        }
        s.close();
    }
}