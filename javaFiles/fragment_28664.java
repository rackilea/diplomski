@Entity
public class Entity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private String latitude;
    private String longitude;

    @Transient
    private double distance;

    @PostLoad 
    public void postLoad(){
        distance = latitude - 1;
    }
}