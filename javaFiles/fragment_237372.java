double min = Double.MAX_VALUE;
Integer index;

Set<Integer> keys = map.keySet();
Iterator it = keys.iterator();

while(it.hasNext())
{
    Integer key = it.next();
    double dist = distance( map.get(key), checklist);
    if( dist < min )
    {
        min = dist;
        index = key;
    }
}