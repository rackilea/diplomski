// run a for loop that will let user guess 10 times
for (int i = 0; i < 10; i++)
{
    // see if the guessed number is incorrect
    if (g1 != n)
    {
         // check whats wrong with the number entered

         // number of guesses cannot exceed 10
         if ((i+1) >= 10)
         {
             System.out.println("\nGAME OVER\nYou have exceeded the max # of tries!"); 
         }
         else if (g1 < n)
         {
             // if user's guess is less than the number
             System.out.println("\nGuess Higher!\n" + (i+1) + "attempt(s) so far"); 
         }
         else if (g1 > n)
         {
             // if user's guess is greater than the number
             System.out.println("\nGuess Lower!\n" + (i+1) + " attempt(s) so far");
         } 
    } 
} // for loop ends