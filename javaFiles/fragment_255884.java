private static <T extends Closeable> void closeResource ( T  item )
{
    try
    {
        if ( item != null )
        {
            item.close();
        }
    }
    catch ( Exception e )
    {
        throw new RuntimeException( e );
    }
}