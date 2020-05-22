@Entity(name = "tableName")
@EntityListeners(value = updateEntityListener.class)
public class ExampleTable{

    @Column(name = "col1")
    private int col1;
    @Transient
    private List<Table2> auditInfo = new ArrayList<Table2>();
    //getter setter
    @Override
    public String toString() {
        return "data";
    }