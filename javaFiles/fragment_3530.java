@Entity
@Table(name = "item")
public class Item implements Serializable {

@Id
@GeneratedValue
private Long id;

// Item columns...

@ManyToOne(optional = false)
@JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
private Order order;

}