public static Dictionary[] getIfPresent(String name)
    {
        List<Dictionary> response = new ArrayList<>(  );

        for(Dictionary d : Dictionary.values())
        {
            if( d.getName().equalsIgnoreCase( name ) )
            {
                response.add(d);
            }
        }
        return response.size() > 0 ?  response.toArray( new Dictionary[response.size()] ) : null;
    }