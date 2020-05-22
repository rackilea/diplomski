/**
 * Skips n bytes. Best effort.
 */
public static void myskip(InputStream is, long n) throws IOException {
    while(n > 0) {
        long n1 = is.skip(n);
        if( n1 > 0 ) {
            n -= n1;
        } else if( n1 == 0 ) { // should we retry? lets read one byte
            if( is.read() == -1)  // EOF
                break;
            else 
                n--;
        } else // negative? this should never happen but...
        throw new IOException("skip() returned a negative value. This should never happen");
    }
}