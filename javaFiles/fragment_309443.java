// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
static int b10_to_b7[] = {0, 1, 2,-1,-1, 3, 4,-1, 5, 6}; // avoids 3, 4 and 7
static int b7_to_b10[] = {0, 1, 2, 5, 6, 8, 9,-1,-1,-1}; // undoes above permutation 

// extracts digits in base b, replacing them according to p
static long permuteDigits(long input, long base, int[] p) {
    long output = 0;
    long shift = 1;
    while (input > 0) {
       int digit = (int)(input % base);
       input /= base;
       output += p[digit] * shift;
       shift *= base;
    }
    return output;
}

// converts input digits in base ibase into obase
static long changeBase(long input, long ibase, long obase) {
    long output = 0;
    long shift = 1;
    while (input > 0) {
       int digit = (int)(input % ibase);
       input /= ibase;
       output += digit * shift;
       shift *= obase;
    }
    return output;
}


permuteDigits(180999565L, 10, b10_to_b7); // 150666343
changeBase(150666343L, 10, 7);            // 10000000  !!