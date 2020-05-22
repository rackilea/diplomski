if (index < length ) {
    char inputIndex = word.charAt(index); // move this line here
    System.out.printf("In word \"%s\", the letter at index"
            + " \"%2d\" is \'%c\'.\n"
            ,word, index, inputIndex );

} else {
    System.out.printf("too big");   
}