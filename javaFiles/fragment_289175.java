@Entity
public class OrderItemMapping  {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long                id;

    @ManyToOne
    @JoinColumn(name="order")
    private Order               order;

    @ManyToOne
    @JoinColumn(name="item")
    private Item item;