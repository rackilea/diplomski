@Entity
@Table(name = "KU_SUPPLIER")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Please provide a name")
    private String name;

    @GsonIgnore
    @OneToMany(mappedBy = "supplier")
    private List<Item> items;  // Should be lazy-loaded

    // Constructor / Getters / Setters
}