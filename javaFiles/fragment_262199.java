public void setFromReference ( Reference ref )
{
    databaseName = getReferenceProperty( ref , "databaseName" );
    String portNumberString = getReferenceProperty( ref , "portNumber" );
    if ( portNumberString != null )
    {
        String[] ps = portNumberString.split( "," );
        int[] ports = new int[ ps.length ];
        for ( int i = 0 ; i < ps.length ; i++ )
        {
            try
            {
                ports[ i ] = Integer.parseInt( ps[ i ] );
            }
            catch ( NumberFormatException e )
            {
                ports[ i ] = 0;
            }
        }
        setPortNumbers( ports );
    } else
    {
        setPortNumbers( null );
    }
    setServerNames( getReferenceProperty( ref , "serverName" ).split( "," ) );

    for ( PGProperty property : PGProperty.values() )
    {
        setProperty( property , getReferenceProperty( ref , property.getName() ) );
    }
}