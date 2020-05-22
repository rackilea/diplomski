private static float baseLength() {
   float baseLength = 0;

   while (true)
   {
   try {
       System.out.print("Enter the base length of the triangle: ");

        Scanner user_input = new Scanner(System.in);
        baseLength = user_input.nextFloat();

        if (baseLength>0)
           return baseLength;

        if (baseLength <=0)
               System.err.println("Error. Plase enter a number higher than 0.");
       } 
       catch (InputMismatchException badChar)
       {   
       System.err.println("You have entered a bad value. Please try again");
       }
   }
 }