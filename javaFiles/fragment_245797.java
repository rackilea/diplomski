boolean askAgain = true;
do {
   System.out.println("would you like to go again?");
   if (input.hasNextLine()){
      String again = input.nextLine();
      if (again.equals("yes")){
        // Finally done asking
        askAgain = false;
        dateconverter.main(args);
      } else if (again.equals("no")){
        System.out.println("good bye");
        Thread.sleep(4000);
        System.exit(0);
      } else {
        // If we're here, we still need to ask again
        System.out.println("Please use either yes or no. caps sensative!");
      }
   } else {
      // no more lines! do something sensible
      System.exit(0);
   }
   // Loop while we need to ask again!
   // Note that the negative is removed
} while (askAgain);