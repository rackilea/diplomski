public String compress(String input){
    int length = input.length(); // length of input
    int ix = 0;                  // actual index in input
    char c;                      // actual read character
    int ccounter;                // occurrence counter of actual character
    StringBuilder output =       // the output
            new StringBuilder(length);

    // loop over every character in input
    while(ix < length){
        // read character at actual index then inc index
        c = input.charAt(ix++);
        // we count one occurrence of this character here
        ccounter = 1;
        // while not reached end of line and next character
        // is the same as previously read
        while(ix < length && input.charAt(ix) == c){
            // inc index means skip this character
            ix++;
            // and inc character occurence counter
            ccounter++;
        }
        // if more than one character occurence is counted
        if(ccounter > 1){
            // print the character count
            output.append(ccounter);
        }
        // print the actual character
        output.append(c);
    }
    // return the full compressed output
    return output.toString();
}