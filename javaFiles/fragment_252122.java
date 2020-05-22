@Named("subBean")
@RequestScoped
public class UserBean implements Serializable{
   //variable is just declared...
   private UserManager vm;

   public UserBean() {
      //and here you're initializing it manually...
      vm = new UserManager();
   }

   //rest of your code...
}