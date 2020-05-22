public class MyClass{
    private Long id;
    private String name;
    private List<Integer> values;

    @Id
    // this is only if your id is really auto generated
    @GeneratedValue(strategy=GenerationType.AUTO) 
    public Long getId() {
        return id;
    }

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public List<Integer> getValues() {
        return values;
    }   
    ...