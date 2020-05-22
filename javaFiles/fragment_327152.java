// function printChars writes n copies of the character c to the
// standard output device
static void printChars (final int [] counters) {
    float MAX_BAR_LENGTH = 20.0;
    int maxScore = 0;
    for (int i = 0; i < 26; i++){
        if(counters[i] > maxScore) {
            maxScore = counters[i];
        }
    }
    float multiplier = maxScore > 0 ? MAX_BAR_LENGTH / maxScore : 0;

    // write the code
    for (int i = 0; i < 26; i++){
        System.out.print("%c%7d\n", i + 'A', counters[i]);
        for(int j = 0; j < (multiplier * counters[i]); j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}