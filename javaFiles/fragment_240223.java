public static Map<String, List<Heading>> sameDescs( List<Heading> input )
{
    Map<String, List<Heading>> ret = new HashMap<String, List<Heading>>();

    for( Heading heading : input )
    {
        if( ! ret.containsKey( heading.getDescription() ) )
        {
            ret.put( heading.getDescription(), new ArrayList<Heading>() );
        }
        ret.get( heading.getDescription() ).add( heading );
    }

    return ret;
}