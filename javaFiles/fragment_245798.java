boolean promptKeepPlaying (Scanner input) { 
   while (input.hasNextLine()){
      System.out.println("would you like to go again?");
      String again = input.nextLine();
      if (again.equalsIgnoreCase("yes")){
        return true;
      } else if (again.equalsIgnoreCase("no")){
        return false;
      } else {
        System.out.println("Please use either yes or no.");
      }
   }
   // no more lines
   return false;
}

// somewhere else
if (promptKeepPlaying(input)) {
  // restart game
  dateconverter.main(args);
} else {
  // exit game
  System.out.println("good bye");
  Thread.sleep(4000);
  System.exit(0);
}