public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    int id;

    @Column(name="country", nullable=false)
    private String country;
    private String street;
    private String postcode;
    private String telephone;
    private String pesel;

    //no user object here

    public int getId() {
        return id;
    }
    ...
}