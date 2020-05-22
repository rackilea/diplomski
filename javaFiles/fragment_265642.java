@Entity
public class Customer {

    @Id
    private long id;

    @OneToOne(mappedBy="customer", cascade={CascadeType.ALL})
    private Address address;

}

@Entity
public class Address implements Serializable {

    @Id
    private long id;

    @OneToOne
    @JoinColumn(name="ID")
    @MapsId
    @XmlInverseReference(mappedBy="address")
    private Customer customer;

}