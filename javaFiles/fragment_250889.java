@Entity
class Role {
  @Id @GeneratedValue
  var id: Long = _

  @Index(name="role_name")
  var name: String = _

  var created_at: Date = _
  var updated_at: Date = _  

  @ManyToMany
  private var sub_role: java.util.Set[Role] = _
  def subRoles: Set[Role] = {
    if (sub_role == null) sub_role = new java.util.HashSet[Role]
    sub_role
  }

  @ManyToMany
  private var permission: java.util.Set[Permission] = _
  def permissions: Set[Permission] = {
    if (permission == null) permission = new java.util.HashSet[Permission]
    permission
  }
}