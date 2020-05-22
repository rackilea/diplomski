public void compareInput(char ... nameInput)
{
    ...

        // Here, nameInput[0] will produce an ArrayIndexOutOfBoundsException 
        // since the nameInput array is empty: 
        if (alphabetLetters[i] == nameInput[0]) 
    ...