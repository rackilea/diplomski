public static void main(String[] args) {
    System.out.print("Enter a word: ");
    Scanner input = new Scanner(System.in);
    while (input.hasNextLine()) {
        String line = input.nextLine();
        if (isPalindrome(line.toCharArray())) {
            System.out.printf("The word %s is a palindrome.%n", line);
        } else {
            System.out.printf("The word %s is not a palindrome.%n", line);
        }
    }

}

public static boolean isPalindrome(char[] word) {
    int i1 = 0;
    int i2 = word.length - 1;
    while (i2 > i1) {
        if (word[i1] != word[i2]) {
            return false;
        }
        ++i1;
        --i2;
    }
    return true;
}