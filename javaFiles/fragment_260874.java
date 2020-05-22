@Entity
public class EntityF implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fId; 
    @ManyToMany
    @JoinTable(name="entitye_entityf",joinColumns =
    @JoinColumn(name = "fId"), inverseJoinColumns =
    @JoinColumn(name = "eId"))
    private Collection<EntityE> entityEs;