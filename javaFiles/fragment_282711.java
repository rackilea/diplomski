@Entity
@Table(name = "activations")
public class UserActivation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long activationId;
    @Column(length = 64)
    private String activationCode;

    @ManyToOne(optional=false)
    @JoinColumn(name="USER_NAME")
    private User user; // since your User Id is username, the join column will be username
}