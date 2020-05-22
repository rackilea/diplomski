@Entity
public class TableA{

    @Id
    private String sNum

    @OneToOne(mappedBy = "resource",cascade = CascadeType.ALL)
    private TableB tableB;

    public TableB getTableB() {         
        return tableB;
    }

    public void setTableB(TableB tableB) {
        this.tableB = tableB;
        tableB.setResource(this); // added this line of code
    }

    //other fields, getter setters
 }