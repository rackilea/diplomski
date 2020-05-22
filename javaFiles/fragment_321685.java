Scanner scan = new Scanner (System.in);
      int input;
      int i = 2;
      int sum = 0;
      int restart;
      do
      {
         System.out.print ("\nEnter a value between 20 and 60: ");
         input = scan.nextInt();

         if (input >= 20 && input <= 60) // checks validity of input
         {
             i = 2;
             sum = 0;
            while (i <= input)
            {
               sum = sum + i;
               i = i + 2;
            }
            System.out.println ("\nSum of even numbers between 2 and " + 
            input + " is: " + sum);
            }
         else 
         {
            System.out.println ("\nInput is not between 20 and 60. ");
         }

         System.out.print ("\nEnter a new value? (1 for yes, any other number for no): ");
         restart = scan.nextInt();
      } while (restart == 1);