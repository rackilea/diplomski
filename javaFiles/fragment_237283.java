@Entity
@Table(name = "header_type")
public class HeaderType extends AbstractBasicEntity {

    /**
     * Serial
     */
    private static final long serialVersionUID = -7471230510640592406L;

    @Id
    //@GeneratedValue(strategy= GenerationType.TABLE) -- this annotations enables automatic generation for table ids
    protected Long id;

    private String name;

    @OrderBy("id")
    @OneToMany(mappedBy = "headerType")
    private Set<EntityHeader> entities = new HashSet<EntityHeader>();

    //Getters and setters
}