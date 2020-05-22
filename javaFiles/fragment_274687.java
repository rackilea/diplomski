@Entity @Table(name = "entity") public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = CustomerInfo.class)
    @JoinTable(name = "customer_info", inverseJoinColumns = {@JoinColumn(name = "customer_id", nullable = false)})
    private CustomerInfo customerInfo;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = CustomerCredentials.class)
    @JoinTable(name = "customer_credentials", inverseJoinColumns = {@JoinColumn(name = "customer_id", nullable = false)})
    private CustomerCredentials customerCredentials;

    //  getter, setters etc }

@Entity @Table(name = "customer_info") public class CustomerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //  getter, setters etc }

@Entity @Table(name = "customer_credentials") public class CustomerCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //  getter, setters etc }