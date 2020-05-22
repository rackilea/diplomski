@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements UsedClasses(){
     public String getNamedQueryForGetAll(){            
         return "User.findAll";
     }
}