skip: {
    for(int i = 0; i < str.length; i++) {
        char c = str.charAt(i);
        if(c == ',' || c == '.' || c == '$')
            break skip;
    }
    /* Your commented out code goes here. */
}