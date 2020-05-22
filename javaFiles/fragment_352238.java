@Entity
@Table(name = "orders")
public class Order {
@Id
@GeneratedValue
private Long id;

@OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
private List<Item> items;

// accessors
}


@Entity
@Table(name = "items")
public class Item {
@Id
@GeneratedValue
private Long id;

@ManyToOne
@JoinColumn(name = "order_id")
private Order order;
    // accessors
}