public static void main(String args[]) {

  // declare your vowels
  List<Character> vowelsList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');

  // get the input string
  Scanner s = new Scanner(System.in);
  System.out.println("Enter String");
  String inputString = s.next();

  if(!inputString.matches("[a-zA-Z]+")) {
    System.out.println("WARNING!!!");
    System.out.println("please input only string");

  } else {
    // Transform your inputString to lower case 
    // (because we only have lower case in our vowels list)
    String lowerCaseInputString = inputString.toLowerCase();

    // Then for each character of the input string, 
    // check if it is in the vowels list or not
    for(char c : lowerCaseInputString.toCharArray()) {
      if(vowelsList.contains(c)) {
        System.out.print(" VOWEL ");
      } else {
        System.out.print(" consonant ");
      }
    }
  }
}