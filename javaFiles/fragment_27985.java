@Entity
public class ObjectMetadata {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String fileName;

    @Temporal(TemporalType.DATE)
    private Date lastModified;

    // constructors, getters, setters
}