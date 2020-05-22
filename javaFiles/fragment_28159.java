while(tk.hasMoreTokens()) {
    String token = tk.nextToken();

    /* If the item is encapsulated in quotes, loop through all tokens to 
     * find closing quote 
     */
    if( token.startsWIth("\"") ){
        while( tk.hasMoreTokens() && ! tk.endsWith("\"") ) {
            // append our token with the next one.  Don't forget to retain commas!
            token += "," + tk.nextToken();
        }

        if( !token.endsWith("\"") ) {
            // open quote found but no close quote.  Error out.
            throw new BadFormatException("Incomplete string:" + token);
        }

        // remove leading and trailing quotes
        token = token.subString(1, token.length()-1);
    }
}