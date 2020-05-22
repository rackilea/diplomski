BufferedReader reader = null;
try {
    reader = new BufferedReader(
        new InputStreamReader(getAssets().open("adverbs")));

    // do reading, usually loop until end of file reading  

} catch (IOException e) {
    //log the exception
}