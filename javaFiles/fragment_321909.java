@Entity(value = "user", noClassnameStored = true)
public class UserEntity extends BaseEntity {

  public static enum Role {
    ADMIN, USER,
  }

  private Role role;

  @Indexed(unique = true)
  private Long userId;

  private Long roleId;

  // Role setter and getter

  public Long getUserId() {
    return userId;
  }
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getRoleId() {
    return roleId;
  }
  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

}