class ModelBase {
    // Initialize the queries
    private static Map<String,String> selectMap = new HashMap<String,String>(); static {
        selectMap.put( "Album", "select field_1, field_2 from album");
        selectMap.put( "Artist", "select field_1, field_2 from artist");
        selectMap.put( "Track", "select field_1, field_2 from track");
    }

    // Finds all the objects for the specified class...
    // Note: it is better to use "List" rather than "ArrayList" I'll explain this later.
    public static List findAll(Class classToFind ) {
        String sql = getSelectSQL( classToFind );
        results = execute( sql );
        //etc...
        return ....
    }

    // Return the correct select sql..
    private static String getSelectSQL( Class classToFind ){
        String statement = tableMap.get( classToFind.getSimpleName() );
        if( statement == null ) {
            throw new IllegalArgumentException("Class " + 
                 classToFind.getSimpleName + " is not mapped");
        }
        return statement;

    }
}