@Entity
@Table(name = "customer")
public class Customer {

    ...

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders;

    /* "Normal" getter to be used in the back-end */ 
    @JsonIgnore // <-- Important as it hides it from Jackson
    public List<Order> getOrders() {
        return orders;
    }

    /* Non-initializing getter for serialization for the front-end */ 
    public List<Order> getOrdersNonInit() {
        return Hibernate.isInitialized(orders) ? orders : null;
    }

    ...

}