public static int getSize(String args){

      // Scanner for keyboard input
      Scanner keyboard = new Scanner(System.in);

      // Declares input as integer
      int input = 0;

      System.out.print(args);
      input = keyboard.nextInt();

      while(input < 2 || input > 7) {
          System.out.print(args);
          input = keyboard.nextInt();
          if (input < 2 || input > 7) 
              System.out.println("The number you entered was not between 2 and 6.");
      }
      return input;
  }