public int[] getPlayerGuess() {

  System.out.print("Guess a four digit code: ");
  String userGuess = Keyboard.readInput();

  if (userGuess.length() != 4) {
    System.out.print("Your code must be 4 digits - ");
    return getPlayerGuess(); // either assign or return the value that is actually calculated within that call...
  }

  int[] userCode = createArrayFromGuess(userGuess);

  for (int i = 0; i < userCode.length-1; i++){
      for (int j = i+1; j < userCode.length; j++){
          if (userCode[i] == userCode[j]) {
              System.out.print("Code must have four unique digits - ");
              return getPlayerGuess(); // either assign or return the value that is actually calculated within that call...
          }
      }
  }
  return userCode;
}