public int countTokens() {
    int count = 0;
    int currpos = currentPosition;
    while (currpos < maxPosition) {
        currpos = skipDelimiters(currpos);
        if (currpos >= maxPosition)
            break;
        currpos = scanToken(currpos);
        count++;
    }
    return count;
}