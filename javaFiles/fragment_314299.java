@Entity
@SecondaryTable(name="OTHER_PERSON")
@AttributeOverride(name="address.street", column=@Column(name="STREET", table="OTHER_PERSON"))
public class Person {

    private Address address;

    @Id
    @GeneratedValue
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @Embedded
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    @Embeddable
    public static class Address implements Serializable {

        private String address;

        public String getStreet() { return street; }
        public void setStreet(String street) { this.street = street; }

    }

}