@Entity
@Table(name = "`order`")
public class Order implements Serializable {

@Id
@GeneratedValue
private Long id;

// Order columns...

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "order_id")
private Set<Item> items;

}