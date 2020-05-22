public int indexOf(final String source, final String find) {
    // loop from first character to last character that still leaves length of 'find' string available
    for(int sourcePos = 0; sourcePos < source.length() - find.length(); sourcePos++) {
        boolean found = true;
        for(int findPos = 0; findPos < find.length(); findPos++) {
            // if the current char is not a match, then mark as not found and break from loop
            if(source.charAt(sourcePos) != find.charAt(findPos)) {
                found = false;
                break;
            }
        }
        if(found) {
            return sourcePos;
        }
    }

    // return -1 to indicate the string was not found
    return -1;
}