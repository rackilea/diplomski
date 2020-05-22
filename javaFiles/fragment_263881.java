@Entity
public class User {

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<UserGroup> userGroups = new HashSet<UserGroup>();

}


@Entity
@Table(name="user_group", 
    uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "group_id"})})
public class UserGroup {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @ForeignKey(name = "usergroup_user_fkey")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    @ForeignKey(name = "usergroup_group_fkey")  
    private Group group;

}


@Entity
public class Group {

    @OneToMany(cascade = CascadeType.ALL, mappedBy="group", fetch = FetchType.LAZY )
    @OnDelete(action = OnDeleteAction.CASCADE)      
    private Set<UserGroup>  userGroups  = new HashSet<UserGroup>();

}