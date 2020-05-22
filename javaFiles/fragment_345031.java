public void doEncode(E event) throws IOException {
    String txt = layout.doLayout(event);

    /*
    * Identify "camel case" upper case letters and also dots in all <TD> output...
    * and insert soft hyphen at this point.  Also make text smaller.
    */
    Pattern tDPattern = Pattern.compile( "<td class=.+?>(.*?)</td>" );
    StringBuilder wholeStringSB = new StringBuilder();
    Matcher tDMatcher = tDPattern.matcher( txt );
    int lastWholeString = 0;
    while( tDMatcher.find() ){
        String tDContents = tDMatcher.group( 1 );
        Matcher camelCaseAndDotMatcher = Pattern.compile("[a-z]([A-Z\\.])").matcher( tDContents );
        StringBuilder camelCaseAndDotSB = new StringBuilder();
        int last = 0;
        while( camelCaseAndDotMatcher.find() ){
            camelCaseAndDotSB.append( tDContents.substring( last,  camelCaseAndDotMatcher.start( 1 ) ));
            camelCaseAndDotSB.append( "&shy;" + camelCaseAndDotMatcher.group(1) );
            last = camelCaseAndDotMatcher.end(1);
        }
        if( last > 0 ){
            // ... at least one camel case UC char and/or dot WAS found...
            wholeStringSB.append( txt.substring( lastWholeString,  tDMatcher.start( 1 )) );
            camelCaseAndDotSB.append( tDContents.substring(last));    
            wholeStringSB.append( camelCaseAndDotSB.toString().trim() );
            lastWholeString = tDMatcher.end();
        }
    }
    wholeStringSB.append( txt.substring( lastWholeString ).trim() );
    txt = wholeStringSB.toString();
    // make text smaller
    txt = txt.replaceAll( "<td class=(.+?)>", "<td style=\"font-size:13px\" class=$1>" );


    outputStream.write(convertToBytes(txt));
    if (immediateFlush)
        outputStream.flush();
}