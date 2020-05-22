public int findIndexOfMax() {
    int maxIndex = 0;
    for (int k = 1; k < myFreqs.size(); k++) {
        if (myFreqs.get(k) > myFreqs.get(maxIndex)) {
            maxIndex = k;
        }
    }
    return maxIndex;
}