@Entity
@Table(name="appusers")
public class AppUser {

    @NotEmpty(message="The user must have at least one defined role")
    @OneToMany(fetch = FetchType.LAZY, cascade = cascadeType.ALL, mappedBy = "appUser")
    private Set<AppUserRole> userRoles = new HashSet<AppUserRole>(0);

    /**
    *   Force clients through add/remove. Plus, do not provide setter.
    */
    public Set<AppUserRole> getUserRoles() {
        return Collections.unmodifiableSet(userRoles);
    }

    public void addRole(AppUserRole userRole){
        userRole.setAppUser(this); //both sides set
        userRoles.add(userRole);
    }

    public void removeRole(AppUserRole userRole){
        userRoles.remove(userRole);
    }
}