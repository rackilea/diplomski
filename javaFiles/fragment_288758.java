@Table
@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1, max = 35)        
    private String name;

    @ManyToMany
    private List<Student> friends = new ArrayList<Student>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getFriends() {
        return friends;
    }

    public void setFriends(List<Student> friends) {
        this.friends = friends;
    }

}