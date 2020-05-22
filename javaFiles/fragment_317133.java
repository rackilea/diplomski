public static void letters(char c) {
    if (c > 'a') {
        letters((char)(c - 1)); // do not decrement c
    } // no else block since we dont need it
    System.out.print(c + " ");
}