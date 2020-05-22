boolean validNumber = false;
while (!validNumber) {
  System.out.println ("Please Enter your Student Number: ");
  userInput = in.next();

  if (userInput.charAt(0) == firstLetter) {
    validNumber = true;
  } else {
     System.out.println("No match, Student Numbr must begin with character capital X ");
  }
}