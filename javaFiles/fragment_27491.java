@Entity
@Table(name="PRODUCT_ORDER")
@IdClass(ProductOrderId.class)
public class ProductOrder {

    @Id
    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    @ManyToMany
    @JoinTable(name="PRODUCT_ORDER_ADDRESS",
            joinColumns={@JoinColumn(name="ORDER_ID", referencedColumnName="ORDER_ID"),
                    @JoinColumn(name="PRODUCT_ID", referencedColumnName="PRODUCT_ID")},
            inverseJoinColumns=@JoinColumn(name="ADDRESS_ID", referencedColumnName="ADDRESS_ID"))
    private List<Address> addressList = new ArrayList<Address>();
...
}