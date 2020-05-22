@Entity
@Table(name = "Sites")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_Site", unique = true, nullable = false)
    private long Id_Site;
    private String ...;
    private boolean ...;
    private long ...; 
    private Date ...;
    private Date ...;
    private String ...;

    @OneToMany(mappedBy="site", fetch = FetchType.EAGER)
    private Set<Sequence> sequences = new HashSet<>();


@Entity
@Table(name = "Sequences")
public class Sequence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_Sequence", unique = true, nullable = false)
    private long Id_Sequence;
    private Date ....;
    private Date ....;
    private String ....;
    private String ....;
    private String ....;
    private int ....;
    private int ....;
    private double ....;
    private double ....;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Sequence> traceSequences = new HashSet<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "site_Id_Site", nullable = false)
    private Site site;