public class B {
    String id;
    String aId;
    A a;

    @Id
    @GenericGenerator(name = "seq_id", strategy = "generators.SequenceIdGenerator")
    @GeneratedValue(generator = "seq_id")
    @Column(name = "ID", unique = true, nullable = false, length = 28)
    public String getId() {
        return this.id;
    }

    @Id
    public String getAId() {
        return aId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "A_ID", nullable = false)
    @MapsId("aId")
    public A getA() {
        return this.a;
    }
}