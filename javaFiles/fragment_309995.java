@Entity
public class AddressDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AddressID")
    private int addressId;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private CityDomain cityDomain;

    @ManyToOne
    @JoinColumn(name = "StateID", nullable = true)
    private StateDomain stateDomain;

}