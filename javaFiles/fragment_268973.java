private int calcMid(int length) {
    if ( length <= 4 )
        return length / 2;
    int levelSize = 1;
    int total = 1;
    while ( total < length ) {
        levelSize *= 2;
        total += levelSize;
    }
    int excess = length - (total - levelSize);
    int minMid = (total - levelSize + 1) / 2;
    if ( excess <= levelSize / 2 ) {
        return minMid + (excess - 1); 
    } else {
        int midExcess = levelSize/2; 
        return minMid + (midExcess - 1);
   }
}