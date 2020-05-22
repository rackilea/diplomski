public static int recursSum(int startingNum, int numInts) {
    if (numInts == 0) {
        // eventually the numInts will become 0, meaning there's no
        // numbers to add after this startingNum, so just return it
        return startingNum;
    }

    // otherwise, if numInts > 0, that means there are other numbers to add so
    // return the sum of the current number with the output of the function called
    // on the next number (while not forgetting to decrease the number of integers
    // we should consider after that)
    return startingNum + recursSum(startingNum + 1 /* next number */, numInts - 1 /* decrease the number of integers to consider after that */);
}