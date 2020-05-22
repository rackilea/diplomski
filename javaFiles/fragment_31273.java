int i = 1;
while( properties.get( "server" + i + ".serverName" ) != null ) {
    ServerDetails details = new ...
    details.setServerName( properties.get( [as above] ) );
    ...
    list.add( details );
    ++i;
}