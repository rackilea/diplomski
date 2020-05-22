public class User {
    final int userId;
    final String userName;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    static final Attribute<User, Integer> USER_ID   = attribute(u -> u.userId);
    static final Attribute<User, String>  USER_NAME = attribute(u -> u.userName);
}

public class Role {
    final int roleId;
    final String roleName;

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    static final Attribute<Role, Integer> ROLE_ID   = attribute(r -> r.roleId);
    static final Attribute<Role, String>  ROLE_NAME = attribute(r -> r.roleName);
}

public class UserRole {
    final int userId;
    final int roleId;

    public UserRole(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    static final Attribute<UserRole, Integer> USER_ID = attribute(ur -> ur.userId);
    static final Attribute<UserRole, Integer> ROLE_ID = attribute(ur -> ur.roleId);
}