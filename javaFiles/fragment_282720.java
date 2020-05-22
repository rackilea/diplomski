@Entity
@IdClass(AssignedRoleId.class)
public class AssignedRole
{
  @Id
  @ManyToOne
  private User userId;

  @Id
  @ManyToOne  
  private Role roleId;

  private Date dateAssigned;
}