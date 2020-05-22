Stream stream = null;
try {
    stream = makeNewStream();
    // more stuff
} catch(SomeException e) {

} finally {
    if(stream != null) {
        try {
            stream.close()
        } catch(ClosingException e) {
            // ignore this
        }
    }
}