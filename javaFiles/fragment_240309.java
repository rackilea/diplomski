try{
  randomGuess = scanner.nextInt();
  guessResult = checkGuess(randomGuess);
}
catch(Exception ex){
  System.out.println("Invalid argument");
}