@Entity
public class Customer {
  @Id
  @Column(name="cust_id")
  private long id;
  ...
  @OneToMany
  @JoinColumn(name="owner_id", referencedColumnName="cust_id")
  private List<Order> order;
  ...
}

@Entity
public class Order {
    @Id
    @Column(name="order_id")
    private long id;
    ...
}