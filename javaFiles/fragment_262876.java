@Entity
public class ProductType {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "type")
    private List<Product> products;

    // Getters and setters
}