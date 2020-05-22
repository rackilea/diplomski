private <T> void newMapElement( Map<? extends T, ? extends T> userMap, Map<? super T, ? super T> newUserMap, int maxSize)
{
    int i = 0;
    for ( Map.Entry<? extends T, ? extends T> entry : userMap.entrySet() )
    {
        newUserMap.put( entry.getKey(), entry.getValue() );
            i++;
            if ( i == maxSize)
            {
                break;
            }
    }
}