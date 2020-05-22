for (int Letter = 1; Letter < PhraseLength-1; Letter++) {
    int IndexFromFront = Letter;
    int IndexFromBack = PhraseLength-1-Letter;
    // Print character from the start of string at given Index 
    System.out.print(CapPhrase.charAt(IndexFromFront));
    // Print required spaces
    for (int Space = 0; Space < 2*(PhraseLength-1)-1; Space++) {
        System.out.print(" ");
    }
    // End space print
    // Print character from the end of string matching the required index
    System.out.print(CapPhrase.charAt(IndexFromBack));
    // Printing on this line is complete, so print a new line.
    System.out.println();
}