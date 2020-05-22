@Entity
@Table(name = "Orders")
public class Order {
    @Id Long id;
    @OneToMany(mappedBy="order")
    private List<OrderDetail> orderItems;
}

@Entity
@Table(name="PRODUCTS")
public class Product {
    @Id Long id;
    @OneToMany(mappedBy="product")
    private List<OrderDetail> orderItems;
}

@Entity
@IdClass(OrderDetailId.class)
@Table(name = "ORDER_DETAIL")
public class OrderDetail implements Serializable {
    @Id @ManyToOne @JoinColumn(name = "ORDER_ID")
    private Order order;

    @Id @ManyToOne @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "PRICE") private double price;
    //Maybe you also want to use @TemporalType here
    @Column(name = "LAST_UPDATED_TIME") private Date lastUpdatedTime;
}

public class OrderDetailId implements Serializable {
    private Long order;
    private Long product;
}