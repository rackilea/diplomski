@Entity
public class ContactDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ContactID")
    private int contactId;

    @Column(name = "ContactNumber")
    private int contactNumber;

    @ManyToOne
    @JoinColumn(name = "PersonID", nullable = true)
    private PersonsDomain personsDomain;

    @Column(name = "Description")
    private String description;
}