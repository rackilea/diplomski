public class User {

    private Long id;
    private String username;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }   

    //other fields/getters/setters...
}