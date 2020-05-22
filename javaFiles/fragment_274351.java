public class Users {
     private String name;
     public static Users user;

     public static Users getInstance(){
        if(user == null)
           user = new Users();
        return user;
     }

     private Users(){

     }    

     public String getName() {
         return name;
     }

     public void setName(String name){
         this.name=name;
     }
 }