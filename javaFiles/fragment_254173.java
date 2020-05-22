//Translate
for ( int j = 0, t=0; j < phrase.length(); j++) {
    if ( phrase.substring(t, (t+1) ).equals ( english[j] ) ) {
        translation[t] = morse[j];
        t++;
    }
}