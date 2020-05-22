for (int i = 0; i < size; i++)             // i is the loop variable for the character count, we'll print one line for each character
{
    for (int j = 0; j < array.length; j++) // for every string in the array
    {
        char c = ' ';                      // print out a space character by default to keep the columns aligned
        if ( array[j].length() > i )       // but if the array[j] still has characters left
            c = array[j].charAt(i);        // print that character instead
        System.out.print(c + " ");         // here
    }
    System.out.println();                  // and close the line
}