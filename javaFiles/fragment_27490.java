@Entity
@Table(name="ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Long id;

    private String state;

    @ManyToMany(mappedBy = "addressList")
    private List<ProductOrder> productOrderList = new ArrayList<ProductOrder>();
...
}