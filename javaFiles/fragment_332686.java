private int select(int[] numArray, int k) {
    int knownCorrectAnswer = selectSlowlyButDefinitelyCorrectly(numArray, k);
    int willReturn;
    if (numArray.length <= 10) {
        int[] sorted = insertionSort(numArray);
        willReturn = sorted[k];    // Just remember what we will return
    } else {    // Need to add else branch here now

        ...

        if (k < lt.size()) {
            willReturn = select(createArray(lt), k);
        } else if (k > lt.size() + eq.size()) {
            willReturn = select(createArray(gt), k - lt.size() - eq.size());
        } else {
            willReturn = M;
        }
    }    // End of inserted else branch

    if (willReturn == knownCorrectAnswer) {
        return willReturn;
    } else {
        yell("First problem occurs with numArray=<...> and k=<...>!");
    }
}