int min = 32;
int max = 127;
int numChars = 6; //Set to whatever value you like.
int numDifferentChars = max - min;
int numPossibilities = (int)Math.pow(max - min,numChars);
for(int i = 0;i < numPossibilities;i++) {
    char[] chars = new char[numChars];
    for(int j = 0;j < numChars;j++) {
        int chr = i;
        for(int k = 0;k < j;k++) {
            chr /= numDifferentChars;
        }
        chars[j] = (char)((chr % numDifferentChars) + min);
    }
    doStuffWith(String.valueOf(chars));
}