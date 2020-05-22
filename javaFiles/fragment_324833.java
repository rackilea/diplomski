public checkPalindrome(String word){
    reverseWord="";
    for(int x=word.length-1;x>=0;x--){
        reverseWord = reverseWord+wordArray[x];

    }
    System.out.println(reverseWord);
    if(wordGuess.equalsIgnoreCase(reverseWord))
    {
        System.out.println("");
        System.out.println("You have found a Palindrome!!!");
        System.out.println("The Palindrome we found was "+reverseWord);
        break;
   }
   else{
        System.out.println("");
        System.out.println("You have not entered a Palindrome...");
        System.out.println("Please Try again...");

  }

}