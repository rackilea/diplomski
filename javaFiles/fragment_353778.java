String sanitize(String url) throws EncodingException{

    Encoder encoder = new DefaultEncoder(new ArrayList<String>());
    //first canonicalize
    String clean = encoder.canonicalize(url).trim();
    //then url decode 
    clean = encoder.decodeFromURL(clean);

    //detect and remove any existent \r\n == %0D%0A == CRLF to prevent HTTP Response Splitting
    int idxR = clean.indexOf('\r');
    int idxN = clean.indexOf('\n');

    if(idxN >= 0 || idxR>=0){
        if(idxN>idxR){
            //just cut off the part after the LF
            clean = clean.substring(0,idxN-1);
        }
        else{
            //just cut off the part after the CR
            clean = clean.substring(0,idxR-1);
        }
    }

    //re-encode again
    return encoder.encodeForURL(clean);
}