@Entity
@Table(name = "KU_SUPPLIER")
public class Supplier {

    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Expose
    @NotEmpty(message = "Please provide a name")
    private String name;

    @OneToMany(mappedBy = "supplier")
    private List<Item> items;  // Should be lazy-loaded

    // Constructor / Getters / Setters
}