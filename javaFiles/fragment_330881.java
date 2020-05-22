if ( charCount <= 160 ) {
    nSegments = 1;
    countDown = 160 - charCount;
} else if ( charCount % 153 == 0 ) {
    nSegments = charCount / 153;
    countDown = 0;
} else {
    nSegments = charCount / 153 + 1;
    countDown = nSegments * 153 - charCount;
}
lblCharCounter.setText(String.format("%d SMS %d", nSegments, countDown) );