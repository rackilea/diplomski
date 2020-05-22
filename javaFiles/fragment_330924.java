System.out.println("Is your car an import?");
  while (true)
  {
     answer = keyboard.nextLine();
     if (answer.equalsIgnoreCase("yes")) 
   {
     yn = true;
     break;
   } 
        else if (answer.equalsIgnoreCase("no"))
        {
           yn = false;
           break;
         } 
           else 
           {
           System.out.println("Sorry, I didn't catch that. Please answer yes or no");
           }

   }