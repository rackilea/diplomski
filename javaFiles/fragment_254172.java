//Translate
for ( int j = 0, t = 0, n = 1; j < phrase.length(); j++) {
    if ( phrase.substring(t, n ).equals ( english[j] ) ) {
        translation[t] = morse[j];
        t++;
        n++;
    }
}