@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="role_id", unique=true, nullable=false)
private Integer roleId;

@Column(name="role_name", length=45)
private String roleName;

//bi-directional many-to-one association to User
@OneToMany(mappedBy="role")
private List<User> users;

public Role() {
}

public Integer getRoleId() {
    return this.roleId;
}

public void setRoleId(Integer roleId) {
    this.roleId = roleId;
}

public String getRoleName() {
    return this.roleName;
}

public void setRoleName(String roleName) {
    this.roleName = roleName;
}

public List<User> getUsers() {
    return this.users;
}

public void setUsers(List<User> users) {
    this.users = users;
}

public User addUser(User user) {
    getUsers().add(user);
    user.setRole(this);

    return user;
}

public User removeUser(User user) {
    getUsers().remove(user);
    user.setRole(null);

    return user;
}

 }


@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
private static final long serialVersionUID = 1L;


// bi-directional many-to-one association to Role
@ManyToOne
@JoinColumn(name = "role_role_id", nullable = false)
private Role role;



public Role getRole() {
    return this.role;
}

public void setRole(Role role) {
    this.role = role;
}



}