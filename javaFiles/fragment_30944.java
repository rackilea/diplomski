Stream stream = null;
try {
    stream = makeNewStream();
    // more stuff
} catch(SomeException e) {

} finally {
    stream.close()
}