@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    private int quantity;

    @OneToMany(mappedBy = "order")
    private List<ProductOrder> productOrderList = new ArrayList<ProductOrder>();
...
}