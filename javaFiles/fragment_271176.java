if  (guess == number)
      { 
         System.out.println("You are correct! the number was " + number + "!");
         win = true;
   } 
      else if (guess > number)
      {
         System.out.println("That number is too high.");
      }
      else if (guess < number)
      {
         System.out.println("That number is too low.");
      }