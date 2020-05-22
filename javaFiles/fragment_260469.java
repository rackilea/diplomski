@Entity
@Table(name = "rightrole")
public class RightRole extends BaseEntity<RightRolePK> {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected RightRolePK rightRolePK;

    @MapsId("roleID")
    @JoinColumn(name = "roleID", referencedColumnName = "roleID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    @MapsId("rightID")
    @JoinColumn(name = "rightID", referencedColumnName = "rightID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Right right;

    ......
 }