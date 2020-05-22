for ( String uri : anonURIs ) {
    if ( ... ) {
        chain.doFilter( ... );
        return;
    }
}

String authToken = getTokenFromRequest( httpRequest );
...