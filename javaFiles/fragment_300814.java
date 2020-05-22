@MappedSuperclass
@Access(AccessType.PROPERTY)
public abstract class FinanceEntityBean {
    protected Long id;

    @Version
    @Access(AccessType.FIELD)
    private long version;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}