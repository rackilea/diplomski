int numbers[] = new int [10]; 

   for (int i = 0 ; i < 10 ; i++) 
   { 
   numbers [i] = (int) (Math.random () * 100); 
   }

  System.out.println ("The size of the array: " + numbers.length);

  System.out.println ("The numbers in order:");

  for (int index = 0; index < 10; index++)
      System.out.print (numbers[index] + "  ");

  System.out.println ("\nThe numbers in reverse order:");

  for (int index = numbers.length-1; index >= 0; index--)
     System.out.print (numbers[index] + "  ");