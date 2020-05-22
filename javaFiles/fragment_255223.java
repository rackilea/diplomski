@Entity(name = "permission_t")
public class Permission extends BaseEntity implements GrantedAuthority {

    @Column (name = "permission_name", nullable = false)
    private String permissionName;

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }   

    @Override
    public String getAuthority() {
        return permissionName;
    }

    @Override
    public int hashCode() {
        return permissionName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Permission)) return false;
        return ((Permission) obj).getAuthority().equals(permissionName);
}