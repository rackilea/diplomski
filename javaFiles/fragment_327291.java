String val = "{alpha}{beta}{delta\nepsilon}";
    Pattern pattern = Pattern.compile( "\\{(.*?)\\}", Pattern.DOTALL);
    Matcher matcher = pattern.matcher( val );
    while ( matcher.find() ) {
        String part = matcher.group(1);
        System.out.print( String.format("%s,", part));
    }