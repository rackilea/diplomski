@Entity
@Table(name = "TableName")
public class TableNameClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", insertable = false, nullable = false, unique = true, updatable = false)
    private int ID;

    ...
}