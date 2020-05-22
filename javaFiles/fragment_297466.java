public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter a letter: ");
    String letter = keyboard.nextLine();
    System.out.println("Please enter an integer: ");
    int digit = keyboard.nextInt();
    System.out.println(isVowel(letter));
    System.out.println("The reversed digits are: " + reverseDigit(digit));
}