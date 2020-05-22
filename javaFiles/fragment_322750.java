@Entity
@Table( name="ROLES" )
public class Role {

    @Id
    @Column( name="GROUP_ID")
    private String id;

    @Column( name="GROUP_DESC" )
    private String description;

    @ManyToMany(mappedBy="roles")
    @JsonIgnore
    private List<User> users = new ArrayList<User>();

    //Getters and Setters go here
}