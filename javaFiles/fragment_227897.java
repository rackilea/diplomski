String[] line = value.toString().split(": ");
if(line.length >= 2){

    listing.set(line[0]);

    //Create an array of words contained in each line
    String [] tokens = line[1].split(" ");
    int count = tokens.length;

    for (String token : tokens){
        wordText.set(token);
        context.write(wordText, listing);
    }
} else {
    // increase the counter for tacking bad lines
    context.getCounter("INVALID_LINES").increment(1);
}