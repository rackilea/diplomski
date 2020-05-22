final static int MIN_WORD_LENGTH=2;
final static int MAX_WORD_LENGTH=9;

int counts[MAX_WORD_LENGTH-MIN_WORD_LENGTH];  // allow for longer words :-)

private void addWord(int length) {
     if ((length >=2) && (length < MAX_WORD_LENGTH)) 
         counts[length-MIN_WORD_LENGTH]++;
}