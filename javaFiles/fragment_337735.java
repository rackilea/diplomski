public class EntityX {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true, insertable = true)
    private String id;

    @OneToMay(mappedBy = "x", cascade = CascadeType.ALL)
    private List<A> aList;

    // getters and setters

}
public class EntityA {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true, insertable = true)
    private String id;

    @ManyToOne
    @JoinColumn(name = "idX")
    private X x;

    //and so on

    // getters and setters

}