@Entity
public class Sell implements Serializable {

    @Id
    @GeneratedValue(generator = "sell_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sell_sequence", sequenceName = "sell_sequence", allocationSize = 1)
    private Long id;

    // other fields...

    @OneToMany(cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST },mappedBy = "sell")

    private List<Offer> offers = new ArrayList<>();

    // constructors, getters and setters...
}

@Entity
public class Buy implements Serializable {

    @Id
    @GeneratedValue(generator = "buy_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "buy_sequence", sequenceName = "buy_sequence", allocationSize = 1)
    private Long id;

    // other fields...

    @OneToMany(cascade = { CascadeType.REMOVE },mappedBy = "buy")
    private List<Offer> offers;

    // constructors, getters and setters...
}

@Entity
public class Offer implements Serializable {

    @Id
    @GeneratedValue(generator = "offer_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "offer_sequence", sequenceName = "offer_sequence", allocationSize = 1)
    private Long id;

    @Column(length = 500)
    String description;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "bidder_id", nullable = false)
    User bidder;

    @ManyToOne
    @JoinTable(name = "selloffer",
        joinColumns =  @JoinColumn(name = "offer_id", referencedColumnName = "id"),
        inverseJoinColumns =@JoinColumn(name = "sell_id", referencedColumnName = "id"))
    private Sell sell;

    @ManyToOne
    @JoinTable(name = "buyoffer",
        joinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "buy_id", referencedColumnName = "id"))
    private Buy buy;
}