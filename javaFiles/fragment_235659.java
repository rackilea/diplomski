public void actionPerformed(ActionEvent e) {
    String action = e.getActionCommand();
    if (action == "Guess Letter"){
        inputChar = JOptionPane.showInputDialog("Please enter letter (a-z)");
        if (inputChar.length() > 1){ //User input is a string here, right?
            GuessedLetters glr = new GuessedLetters(inputChar);
            glr.setInString(inputChar);
            System.out.println(wordToGuess.contains(glr.getInString())); //This will print true if wordToGuess is equal to glr.getInString() or if it just contains it
            //For testing purposes
            System.out.println("This is String: " +glr.getInString());              
        }else{ //Here the user gave us just a character, so we've got to know if this character is contained in the word, right?
        GuessedLetters glr = new GuessedLetters(inputChar);
        glr.setInChar(inputChar);
        System.out.println(wordToGuess.contains(glr.getInChar()); //This will print true if your char is in the wordToGuess string
        //For testing purposes
        System.out.println("This is Char: " +glr.getInChar());
        }
    }
}