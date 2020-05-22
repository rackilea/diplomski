@Entity
public class Customer extends Model {

    @Id
    public Integer id;
    public String email;
    @ManyToOne
    public List<Order> orders;

    @Transient
    @Formula(...) // write the query to compute the sum
    public Integer totalOrders;

    public HashMap<String, Object> additionalData;

    public static Finder<Integer, Customer> find = new Finder<Integer, Customer>(Integer.class, Customer.class);

    public static List<Customer> getCustomersWithOpenOrders(){
        ...// call the finder

        additionalData.put("sum", totalOrders);
        ...
    }
...
}