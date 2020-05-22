if (guess.toUpperCase().equals(color))
{
            System.out.println("Correct my favorite color is " + color);
            // Explicitly set "again" to "n" so that we won't loop again
            again = "n";
}

else
// Add brackets so that it only prompts the user for input if they had a wrong answer
{
            System.out.println("Incorrect. Would you like to try again? (y/n)" + colorchoice);
        again = keyboard.next();
}