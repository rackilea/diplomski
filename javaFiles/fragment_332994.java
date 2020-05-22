@Entity
@Table(name = "isin")
public class IsIn {

    @EmbeddedId
    private UserGroupId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn("groupId")
    private Group group;