@Entity
@Table(name="opinions")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String text;

    @NotNull
    private String date;

    @ManyToOne
    @JoinColumn(name="commented_user")
    private User writtenTo;

    // map author to User entity
    @ManyToOne
    @JoinColumn(name="authored_user")
    private User author;

    // getters and setters
}