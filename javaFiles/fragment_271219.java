public static void main(String args[]) {
  String vowels = "aeiouAEIOU";
  char[] vowelsArray = vowels.toCharArray();

  Scanner s = new Scanner(System.in);
  System.out.println("Enter String");
  String inputString = s.next();
  char inputStringArray[] = inputString.toCharArray();

  if(inputString.matches(".*\\d+.*")) {
    System.out.println("WARNING!!!");
    System.out.println("please input only string");
  } else {
    for(int i=0;i<inputStringArray.length;i++) {
      // Declare a boolean to say if the character is a Vowel or not
      boolean isVowel = false;
      // Check the character and set the boolean value
      for(int j=0;j<vowelsArray.length;j++) {
        if(inputStringArray[i]==vowelsArray[j]) {
          isVowel = true;
          break;
        }
      }
      // Then do the printing here, in the input characters loop
      if(isVowel) {
        System.out.print(" VOWEL ");
      } else if(inputStringArray[i]!=vowelsArray[i]) {
        System.out.print(" consonant ");
      }
    }
  }