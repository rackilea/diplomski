private static char wrapChar(char input, int amount) {
    //assume for now that we have an upper-case letter
    char start = 'A';
    //if the assumption is mistaken...
    if (('a' <= input) && (input <= 'z')) {
        //then, if it is lower-case, then use lower-case
        start = 'a';
    } else if (!(('A' <= input) && (input <= 'Z'))) {
        //target is not letter
        return input;
    }
    //Calculate total offset compared to the first letter of the alphabet
    //be it lower or upper
    int offset = ((input - start) + amount) % 26;
    //If offset happens to be negative, then shift a modulo period of 26
    //To get the correct positive offset
    if (offset < 26) {
        offset += 26;
    }
    //Add the final offset to start and convert it to char
    return ((char)(start + offset));
}