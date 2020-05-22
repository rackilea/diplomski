// possible roles
public enum Role {
    ADMIN, USER, GUEST
}

// bean for binding
public class User {
    private Set<Role> roles;
    private String name;

    public User(String name, Set<Role> roles) {
        this.roles = roles;
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "roles=" + roles +
                ", name='" + name + '\'' +
                '}';
    }
}