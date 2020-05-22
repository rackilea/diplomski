Scanner reader = new Scanner(System.in);
System.out.println("Enter a  a string: ");
String DAWORD = reader.nextLine();

reader.close();

int n = DAWORD.length();
boolean isPalindrome = true;
for (int i = 0; i < n; ++i) {
    if (DAWORD.charAt(i) != DAWORD.charAt(n - i - 1)) {
        isPalindrome = false;
        break;
    }
}
if (isPalindrome)
    System.out.println("This word is a palindrome");
else
    System.out.println("This word is not a palindrome");