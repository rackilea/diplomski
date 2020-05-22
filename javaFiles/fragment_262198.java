public Object getObjectInstance ( Object obj , Name name , Context nameCtx ,
                                  Hashtable < ?, ? > environment ) throws Exception
{
    Reference ref = ( Reference ) obj;
    String className = ref.getClassName();
    // Old names are here for those who still use them
    if ( 
            className.equals( "org.postgresql.ds.PGSimpleDataSource" )
            || className.equals( "org.postgresql.jdbc2.optional.SimpleDataSource" )
            || className.equals( "org.postgresql.jdbc3.Jdbc3SimpleDataSource" ) 
    )
    {
        return loadSimpleDataSource( ref );
    } else if ( 
            className.equals( "org.postgresql.ds.PGConnectionPoolDataSource" )
            || className.equals( "org.postgresql.jdbc2.optional.ConnectionPool" )
            || className.equals( "org.postgresql.jdbc3.Jdbc3ConnectionPool" ) 
    )
    {
        return loadConnectionPool( ref );
    } else if ( 
            className.equals( "org.postgresql.ds.PGPoolingDataSource" )
            || className.equals( "org.postgresql.jdbc2.optional.PoolingDataSource" )
            || className.equals( "org.postgresql.jdbc3.Jdbc3PoolingDataSource" ) 
    )
    {
        return loadPoolingDataSource( ref );
    } else
    {
        return null;
    }
}