boolean keepRunning = true;
while( keepRunning ) {
  //ask for input, calculate, print - the bulk of your code above

  System.out.println("Would you like to do another? y/n");

  String userInput = ...; //get from scanner, I'll leave this as an excercise for you
  keepRunning = "y".equalsIgnoreCase( userInput ); //you might want to be more lenient here, e.g. also accept "yes" etc.
}