@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    private String password;

    @OneToMany(mappedBy="writtenTo")
    private List<Opinion> opinions;

    // map opinions to the author
    @OneToMany(mappedBy="author")
    private List<Opinion> authoredOpinions;

    // getters and setters
}