/**
 * A EntityExample.
 */
@Entity
@Table(name = "T_ENTITYEXAMPLE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EntityExample implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;