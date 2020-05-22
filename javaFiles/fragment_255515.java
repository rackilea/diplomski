// get first occurrence of a substring between single quotes
String getErrorMsg(String text) {
    StringBuilder msg = new StringBuilder();
    int index = 0;
    boolean matchingQuotes = false;      // flag to make sure we matched the quotes
    while(index < text.length()) {      
        if(text.charAt(index) == '\'') { // find the first single quote
            index++;                     // skip the first single quote
            break;
        }
        index++;
    }
    while(index < text.length()) {
        if(text.charAt(index) == '\'') { // find the second single quote
            matchingQuotes = true;       // set the flag to indicate the quotes were matched
            break;
        } else {
            msg.append(text.charAt(index)); 
        }
        index++;
    }
    if(matchingQuotes) {                 // if quotes were matched, return substring between them
        return msg.toString();
    } 
    return "";                           // if reached this point, no valid substring between single quotes
}