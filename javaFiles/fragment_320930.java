// Second option, instance used under the hood.
class ModelBase {
    // Initialize the queries
    private static Map<String,ModelBase> daoMap = new HashMap<String,ModelBase>(); static {
        selectMap.put( "Album", new AlbumModel() );
        selectMap.put( "Artist", new ArtistModel());
        selectMap.put( "Track", new TrackModel());
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
        ModelBase dao = tableMap.get( classToFind.getSimpleName() );
        if( statement == null ) {
            throw new IllegalArgumentException("Class " + 
                 classToFind.getSimpleName + " is not mapped");
        }
        return dao.selectSql();
    }
    // Instance class to be overrided... 
    // this is "protected" ... 
    protected abstract String selectSql();
}
class AlbumModel  extends ModelBase {
    public String selectSql(){
        return "select ... from album";
    }
}
class ArtistModel  extends ModelBase {
    public String selectSql(){
        return "select ... from artist";
    }
}
class TrackModel  extends ModelBase {
    public String selectSql(){
        return "select ... from track";
    }
}