@Entity
@Getter
@Setter
class Person implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "address", joinColumns = @JoinColumn(name = "person_id"))
    private Set<Address> Addresses = new HashSet<>();

    protected Person(){}
}

@Embeddable
@Getter
@Setter
class Address implements Serializable {

    private State state;
    private String postcode;

    protected Address(){}

    // override equals and hascode based on post code only
    // this will give you the desired behaviour
}