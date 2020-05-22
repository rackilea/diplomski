private static int getMask(int numOfOnes) {
        int i = 0x80000000;
        i = i>>(32-numOfOnes-1);
        i = ~i;
        return i;
    }