@Entity  
public class Item { 
    @Id
    @GeneratedValue
    Integer id;

    int quantity;

    @ManyToOne
    Order order;

    // accessors
}