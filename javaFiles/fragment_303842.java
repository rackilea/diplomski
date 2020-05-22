int n=0;
boolean isWord = false; //Use it to track the letters
boolean isSpace = false;
for(int i=0;i<characters;i++) {
    char charToAnalyse = input.getCharAt( i );

    if( charToAnalyse == ' ' ) { //Taking the simple case where you don't have breaklines
        isSpace = true;
        isWord = false;
    }
    else {
        isSpace = false;
        if( !isWord ) {
            isWord = true; //once it is counted, we should avoid recount.
            n++; //Its is the same as n = n + 1;
        }
    }
}
words=characters-n;