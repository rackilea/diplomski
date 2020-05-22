@Entity
public class Entity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private String latitude;
    private String longitude;

    @Formula(latitude - 1)
    private double distance;
}