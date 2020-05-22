public boolean playAgain() {    
    char va;
    // you don't need other variables

    while (true) { // infinite loop ... will only stop if user enters "y" or "n"
                   // you should consider avoiding this loop and take every non "yes" answer as a "no" answer.
        IO.outputln("Want to play again? (y/n)");
        va = IO.inputCharacter();

        if ((va=='y') || (va=='Y')) {
            return true; // instantly return the answer ... no need to stop the loop first
        }
        else if ((va=='n')||(va=='N')) {
            return false; // see above ... instantly return the answer
        }    
    }
}