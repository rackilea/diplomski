@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Type type;
}