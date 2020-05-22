@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column(nullable = false, unique = true, updatable = false, columnDefinition="CHAR(36)")
    private UUID customerId = randomUUID();

    //.....
}