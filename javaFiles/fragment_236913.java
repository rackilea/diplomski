public class SourceToDestinationDetails implements Serializable{

    private static final long serialVersionUID = -7158985673279885525L;
    @Column
    private long sourceToDestinationId;
    @Column
    private String sourcePlace=null;
    @Column
    private String destinationPlace=null;
    @Column
    private String inBetweenPlaces=null;
    @Column
    private String sourceLeavingTime=null;

    @OneToMany(mappedBy = "carpooler_id", cascade = CascadeType.ALL)
    private Set<Carpooler> carpoolers;
}