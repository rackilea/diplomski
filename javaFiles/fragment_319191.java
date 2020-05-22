@Entity
@Table(name="user_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @Column(name="full_name")
    private String fullName;

    //The Adress mapping here
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "Adress_ID", referencedColumnName = "id")
    private Address address;

    public long getId() {
        return id;
    }
    public void setId(long id) {
    this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}