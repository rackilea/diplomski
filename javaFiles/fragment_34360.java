int numPositiveChars = 0;
int numNegativeChars = 0;
for (int i = 0; i < s.length(); i++){
    char c = s.charAt(i);        
    if (/*check c here*/)
        numPositiveChars++;
    else
        numNegativeChars++;
}