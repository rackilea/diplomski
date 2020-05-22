@Named("subBean")
@RequestScoped
public class UserBean implements Serializable{
   //variable is just declared
   //and notify CDI it should inject an instance when creating an instance of the client class
   @Inject
   private UserManager vm;

   public UserBean() {
      //no need to initialize it ever
      //vm = new UserManager();
   }

   //rest of your code...
}