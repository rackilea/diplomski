@MappedSuperclass
public abstract class Approval<T extends CoreStatement> implements java.io.Serializable  {

    private Long id;
    private T statement


    @Id
    @Column(name="ID", unique=true, nullable=false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="STATEMENT_ID", nullable=true)
    public T getStatement() {
        return statement;
    }

    public void setStatement(T statement) {
        this.statement = statement;
    }
}