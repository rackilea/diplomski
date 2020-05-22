@Entity
@Table(name = "table1")
public class Table1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "data")
    private String data;

    @OneToOne(mappedBy = "table1", cascade = CascadeType.ALL)
    private Table2 table2;
    //construct, get, set
}



@Entity
@Table(name = "table2")
public class Table2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "anotherdata")
    private String data;
    //get, set, construct

    @OneToOne
    @PrimaryKeyJoinColumn
    private Table1 table1;
}