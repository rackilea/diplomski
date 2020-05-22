import java.util.Scanner;

public class Done {
    public static void palindrome(String s, String rev) {
        if (rev.equals(s)) {
            System.out.println("This string is a palindrome!");
        }
    }

    public static void reverse(String s) {
        String rev = "";

        for (int i = 0; i < s.length(); i++) {
            rev = rev + s.charAt(s.length() - (i + 1));
        }

        System.out.println("Reversed String:");
        System.out.println(rev);
        palindrome(s, rev);
    }

    public static void main(String[] args) {
        System.out.println("REVERSATRON 2000");
        System.out.println();
        System.out.println("Enter string to reverse: ");
        Scanner scanner = new Scanner(System.in);
        reverse(scanner.nextLine());
    }
}