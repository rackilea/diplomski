private static boolean basicSweep(String input) {
int noOfClosingParentheses = 0;
int noOfOpeningParentheses = 0;
int highScore = 0;
for (int i = 0; i < input.length(); i++) {
    Character currentCharacter = input.charAt(i);
    if (currentCharacter == '(') {
        noOfOpeningParentheses++;

    }
    else if (currentCharacter == ')') {
        noOfClosingParentheses++;
         if(noOfOpeningParentheses >= highScore) {
          highScore = noOfOpeningParentheses;
          } 

      noOfOpeningParentheses--;

    }
}
return false;
}