public boolean displayWord()            
{
    corLetters = 0;  // <---- You should add this line here
    boolean goodGuess = false;automatically
    char letter = guessedLetter.charAt(0);

    for(int i = 0;i<word.length();i++)
        if (lettersFound[i]==true)
        {
         System.out.print(word.charAt(i)+" ");
         corLetters++;
        }
        else if (word.charAt(i)==letter)
        {
            System.out.print(word.charAt(i)+" ");
            lettersFound[i] = true;
            goodGuess = true; 
            corLetters++; 
        }
        else
            System.out.print("_ ");

    return goodGuess;           
}