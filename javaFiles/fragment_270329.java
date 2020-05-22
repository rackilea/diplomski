class RecursivePalindromeTester {

  public static void main(String[] args) {

    //Create objects
    Scanner in = new Scanner(System.in);
    RecursivePalindrome palindrome = new RecursivePalindrome();

    //Output
    for (String again = "Y"; again.equalsIgnoreCase("Y"); again = in.nextLine()) {
      //Prompt for input
      System.out.println();
      System.out.print("Enter a word or phrase: ");
      String phrase = in.nextLine();

      //Output
      if (palindrome.isPalindrome(phrase)) {
        System.out.println("This is a palindrome.");
      }
      else
        System.out.println("This is not a palindrome.");

      System.out.print("Another word or phrase? (Y/N): ");
    }
  }
}