public class UserRole{

   private String user;
   private String role;

   public void setUser(String user) {
       this.user = user;
   }

   public void setRole(String role) {
       this.role = role;
   }

   public String getUser() {
       return user;
   }

   public String getRole() {
       return role;
   }

   @Override
   public String toString()
   {
      return "UserRole [user=" + user + ", role=" + role + "]";
   }

}