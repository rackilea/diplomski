@Data
public class RoleAssociation implements Serializable {

    @Id
    @JoinColumn(name = "has_parent_role_id")
    @ManyToOne // <<<<==== rerequired for Hibernate
    private Role node;

    @Id
    @JoinColumn(name = "is_parent_for_role_id")
    @ManyToOne // <<<<==== rerequired for Hibernate
    private Role parent;