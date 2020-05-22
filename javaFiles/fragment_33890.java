public class TimeRow implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private UserTable table;

    @Basic(optional = false)
    @Column(name = "DAY")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Lob
    @Column(name="ROWVALUES")
    private List<Double> values;

    ...
}