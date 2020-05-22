public boolean isValueFound( int someNumber )
{ 
    for( int i = 0; i < stats.length; i++ )
    {
        if( stats[ i ] == someNumber )
        {
            return true;
        }
    }

    return false;
}