@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @Column(name = "prod_id", unique = true)
    private int id;
    //...
    //...
}