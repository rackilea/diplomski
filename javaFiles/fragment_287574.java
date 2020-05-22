@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Length(min=5)
    private String password;
    private String username;

    @Email
    private String email;
    private String phoneNumber;
    private boolean enabled;
    private boolean verified;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Authority> roles= new HashSet<>();

    //...
}

@Entity
public class Vendor extends User{
        private String name;
        private String description;
        private Date openingTime;
        private Date closingTime;
        @ManyToOne
        private List<File> images;
        //...
}

@Entity
public class Customer extends User{
        private String forename;
        private String surname;
        @ManyToOne
        private List<PaymentDetails> paymentDetailsList;
        //...
}