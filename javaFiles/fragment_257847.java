String rexa = "(\\d+(?:\\.\\d+){3})";  // an IP address
    String rexs = "(\\S+)";                // a single token (no spaces)
    String rexdt = "\\[([^\\]]+)\\]";      // something between [ and ]
    String rexstr = "\"([^\"]*?)\"";       // a quoted string
    String rexi = "(\\d+)";                // unsigned integer

    String rex = String.join( " ", rexa, rexs, rexs, rexdt, rexstr,
                              rexi, rexi, rexstr, rexstr );

    Pattern pat = Pattern.compile( rex );
    Matcher mat = pat.matcher( h );
    if( mat.matches() ){
        for( int ig = 1; ig <= mat.groupCount(); ig++ ){
            System.out.println( mat.group( ig ) );
        }
    }