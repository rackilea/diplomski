// function printChars writes n copies of the character c to the
// standard output device
static void printChars (final int [] counters) {
    // write the code
    for (int i = 0; i < 26; i++){
        System.out.print("%c%7d\n", i + 'A', counters[i]);
        for(int j = 0; j < counters[i]; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}