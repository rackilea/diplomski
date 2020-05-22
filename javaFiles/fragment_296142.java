HashMap<String, Double> collection = new HashMap<String, Double>();

String key = "some key";
...

if( collection.containsKey(key) )
{
    // increment the value
    collection.put( key, collection.get( key ) + 1.0 );
}
else
{
    // initialize the value
    collection.put( key, 0.0 );
}