int col = 0;

LinkedHashMap<String, String> copy = new LinkedHashMap<>();
// you can get the map from arrayList index
LinkedHashMap<String, String> map = table.get( ind1 ); // assuming ind1 is the arrayList index
for ( Map.Entry<String, String> entry : map.entrySet() )
{
    // assuming ind2 is the map index
    if ( ind2 == col )
    {
        copy.put( key, value );
    }
    else
    {
        copy.put( entry.getKey(), entry.getValue() );
    }
    col++;
}
table.set( ind1, copy );