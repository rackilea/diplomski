@MappedSuperClass
public abstract class AbstractParent implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(table="PARENT_TABLE")        
    private String someProperty;

    // getter's and setter's

}