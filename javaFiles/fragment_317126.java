public class Role 
{ 
   @Autowired
   @Transient
   private RoleRepo roleRepo;

   public String id;
   public String name;

   @JsonCreator
   public static Role create(String name) // factory method
   {
      return roleRepo.findRoleByName(name);;
   }
}