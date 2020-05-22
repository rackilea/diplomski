int start = 0;
    for ( int i = 0; i < string.length(); i++ ) {
        if ( !Character.isLetter( string.charAt( i ) ) || i == ( string.length() - 1 ) ) {
            int end = i;
            if ( i == ( string.length() - 1 ) && Character.isLetter( string.charAt( i ) ) )
                end = i + 1;
            String result = string.substring( start, end );
            start = i + 1;
            if ( result.isEmpty() || result.equals( " " ) )
                continue;
            System.out.println( result );
        }

    }