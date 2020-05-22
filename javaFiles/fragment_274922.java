@Entity(name = "owner_login")
@Data
public class OwnerLoginEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private LoginEntity login;

    @ManyToOne
    private OwnerEntity owner;

    public OwnerLoginEntity(LoginEntity login, OwnerEntity owner) {
        this.login = login;
        this.owner = owner;
    }
}