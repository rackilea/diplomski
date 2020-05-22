public static int smallMulti(int num) {
    for (int i = 1; num <= Integer.MAX_VALUE; ++i) { // Check every int in the scope of the Integer
        for (int j = 2;j<=num;++j) {
            if(i % j != 0) {
                break; // If i % j is unequal to 0 then this number isn´t valid.
            }
            if(j == num) {
                return i; // If we reached j == num then everything was divisble yet so we can return i as the correct value;
            }
        }
    }
    return -1;
}