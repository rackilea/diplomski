@Entity
@Table(name = "entity")
public class Entidad extends BaseEntity {

    /**
    * Serial
    */
    private static final long serialVersionUID = 3453805453717178734L;

    @Id
    //@GeneratedValue(strategy= GenerationType.TABLE) -- this annotations enables automatic generation for table ids
    protected Long id;

    protected String name;

    protected String image;

    protected String notes;

    @OrderBy("id")
    @OneToMany(mappedBy = "entity")
    protected Set<EntityHeader> headersType = new HashSet<EntityHeader>();

    //Getters and setters
}