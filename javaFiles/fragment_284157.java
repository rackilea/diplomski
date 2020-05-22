while (true) {
    letter = Character.toUpperCase((char)System.in.read());
    if ((letter > 'Z') || (letter < 'A'))
        break;  // user inputted an invalid symbol, terminating the program
    System.out.print((char)('Z' - (letter - 'A')));
}