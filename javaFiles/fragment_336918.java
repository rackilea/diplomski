@Entity
public class Customer {
    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(name="customer_product",
               joinColumns={@JoinColumn(name="customer_id")},
               inverseJoinColumns={@JoinColumn(name="product_id")})
    private Set<Product> products = new HashSet<Product>();
    ...

@Entity
public class Product {
    @ManyToMany
    @JoinTable(name="customer_product",
               joinColumns={@JoinColumn(name="product_id")},
               inverseJoinColumns={@JoinColumn(name="customer_id")})
    private Set<Customer> customers = new HashSet<Customer>();
    ...