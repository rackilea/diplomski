public class HashMapAccessController
{
    protected HashMap map = null;

    // version - increment this on each update
    // (assuming generation of a new map version
    //  takes measurable time, rollover is a
    //  problem for the next civilization...)
    protected long version = 0;

    public HashMapAccess( HashMap newMap )
    {
        map = newMap;
    }

    public synchronized long getVersion()
    {
        return( version );
    }

    synchronized HashMap getMap()
    {
        return( map );
    }

    synchronized HashMap updateMap( HashMap newMap )
    {
        version++;
        HashMap oldMap = map;
        map = newMap;
        return( oldMap );
    }
}