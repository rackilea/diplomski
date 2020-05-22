@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

    @Column
    private String name;

    @OneToOne(cascade = ALL)
    @JoinColumn(name  = "address")
    private Address address;

    @PrePersist
    @PreUpdate
    public void updateAddressAssociation() {
        if (address != null)
            address.setParty(this);
    }

}