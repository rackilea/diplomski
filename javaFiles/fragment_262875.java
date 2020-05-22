@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private ProductType type;

    // Getters and setters
}