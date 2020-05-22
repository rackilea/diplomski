@Entity
public class EntityE implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eId;
    @ManyToMany
    @JoinTable(name="entitye_entityf",joinColumns =
    @JoinColumn(name = "eId"), inverseJoinColumns =
    @JoinColumn(name = "fId"))
    private Collection<EntityF> entityFs;