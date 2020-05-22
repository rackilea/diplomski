@Entity
public class User
{
   @Id
   private int id;
   @NotNull
   private String fullName;
   @NotNull
   private String email;
   private Set<Role> roles; //No bean validation constraints here.
   ...
   public boolean mapRoleToUser(Role role)
   { //Validation is done here. Including checks for a null role.
   }

}

@Entity
public class Role
{
  @Id
  private int id;
  @NotNull
  private String name;
}