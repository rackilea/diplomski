@Entity
@AssociationOverrides({
        @AssociationOverride(name = "pk.tableA",
                joinColumns = @JoinColumn(name = "FK_TABLE_A", nullable=false)),
        @AssociationOverride(name = "pk.tableB",
                joinColumns = @JoinColumn(name = "FK_TABLE_B", nullable=false)) })
@Table(name="TABLE1")
public class Table1 extends BaseObject implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Table1Id pk = new Table1Id ();

    @EmbeddedId
    public Table1Id getPk() {
        return pk;
    }
    public void setPk(Table1Id pk) {
        this.pk = pk;
    }

    private TableC tableC;
    @ManyToOne
    @JoinColumn(name = "FK_TABLE_C", referencedColumnName = "ID", nullable = true)
    public TableC getTableC() {
        return this.tableC;
    }
    public void setTableC(TableC tableC) {
        this.tableC = tableC;
    }

    private List<Table2> table2s;
    @OneToMany(mappedBy="pk.table1", cascade = {CascadeType.ALL}, orphanRemoval=true, fetch=FetchType.EAGER)
    public List<Table2> getTable2s() {
        return table2s;
    }
    public void setTable2s(List<Table2> table2s) {
        this.table2s= table2s;
    }

    @Override
    public boolean equals(Object o) {
        ...
    }

    @Override
    public int hashCode() {
        ...
    }

    @Override
    public String toString() {
        ...
    }
}

@Entity
@AssociationOverrides({
        @AssociationOverride(name = "pk.table1",
                joinColumns = {
                        @JoinColumn(name = "FK_TABLE_A", nullable=false, insertable=false, updatable=false),
                        @JoinColumn(name = "FK_TABLE_B", nullable=false, insertable=false, updatable=false)
                        }),
        @AssociationOverride(name = "pk.tableD",
                joinColumns = @JoinColumn(name = "FK_TABLE_D", nullable=false)) })
@Table(name="TABLE2")
public class Table2 extends BaseObject implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Table2Id pk = new Table2Id();

    @EmbeddedId
    public Table2Id getPk() {
        return pk;
    }
    public void setPk(Table2Id pk) {
        this.pk = pk;
    }

    private Double value;
    @Column(name = "VALUE", nullable = false, insertable = true, updatable = true, precision = 2)
    @Basic
    public Double getValue() {
        return this.value;
    }
    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        ...
    }

    @Override
    public int hashCode() {
        ...
    }

    @Override
    public String toString() {
        ...
    }
}

@Embeddable
public class Table2Id extends BaseObject implements Serializable 
{
    private static final long serialVersionUID = 1L;

    private Table1 table1;
    @ManyToOne
    @JoinColumn(nullable=false)
    public Table1 getTable1() {
        return this.table1;
    }
    public void setTable1(Table1 table1) {
        this.table1 = table1;
    }

    private TableD tableD;
    @ManyToOne
    @JoinColumn(nullable=false)
    public TableD getTableD() {
        return this.tableD;
    }
    public void setTableD(TableD tableD) {
        this.tableD = tableD;
    }

    @Override
    public boolean equals(Object o) {
        ...
    }

    @Override
    public int hashCode() {
        ...
    }

    @Override
    public String toString() {
        ...
    }
}