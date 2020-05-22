public class StatsCreatorFactory {

    private Map<String, IStatsCreator> statsCreators = new HashMap<String, IStatsCreator>();

    public void registerStatsCreator( String type, IStatsCreator creator ) {
        statsCreators.put( type, creator );
    }

    public IStatsCreator getCreator( String type ){

        IStatsCreator creator= statsCreators.get( type );

        if(creator == null){
            throw new IllegalArgumentException("no creator registered for type : " + type);
        }

        return creator;
    }