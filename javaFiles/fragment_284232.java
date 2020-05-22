@Entity @Table(name="ORDER") public class Order extends Model {
    @Id
    @Column(name="order_number")
    public Integer id;

    @ManyToMany
    @JoinTable(name="ORDER_ITEM",
            joinColumns=@JoinColumn(name="my_order",referencedColumnName = "order_number"),
            inverseJoinColumns = @JoinColumn(name="my_item", referencedColumnName="item_number"))
    public List<Item> items; }