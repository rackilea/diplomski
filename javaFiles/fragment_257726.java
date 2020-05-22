public boolean playAgain() {    

    IO.outputln("Want to play again? (y/n)");
    char va = IO.inputCharacter();

    if ((va=='y') || (va=='Y')) {
        return true;
    }

    return false;
}