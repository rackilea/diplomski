@Entity
public class Order {
    @Id 
    @GeneratedValue
    Integer id;

    @ManyToOne 
    Customer customer;

    @OneToMany 
    Set<Item> items;

    BigDecimal totalCost;

    // accessors
}