@Entity
@Table(name="user_profession")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @Column(name="city")
    private String city;

    //Map the users here
    @OneToMany(mappedBy="adress")
    private Set<User> users;
    //getter and setter

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}