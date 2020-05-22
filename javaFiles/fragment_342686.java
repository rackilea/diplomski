@Entity
public class User {
    @Id @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "groupMemberList")
    private List<GroupMember> groupList;

@Entity
public class GroupMember {
    @Id @GeneratedValue
    private Long id;

    @ManyToMany
    private List<User> groupMemberList;