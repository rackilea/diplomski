public class SourceToDestinationDetails implements Serializable{

    private static final long serialVersionUID = -7158985673279885525L;

    private long sourceToDestinationId;
    private String sourcePlace=null;
    private String destinationPlace=null;
    private String inBetweenPlaces=null;

    private String sourceLeavingTime=null;
    private Set<StockDailyRecord> carpoolers = 
                new HashSet<StockDailyRecord>();
}