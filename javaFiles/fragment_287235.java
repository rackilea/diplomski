@Entity
@Table(name = "A")
public class A{

    @Id
    @Column(name = "a_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "a")
    private List<ACategory> categoryList;

    // no-arg constructor
    public A(){
        // initialise the list in the no-arg constructor to avoid bad surprises...
        this.categoryList = new ArrayList<>();
    }

    // getters & setters
}