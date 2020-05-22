@Entity
@Table(name="user_friends")
public class UserBuddy 
{

   @ManyToOne
   @JoinColumn(name="id")
   private User friend; // This is a User not an id

   public String getEmail()
   {
     return friend.getEmail();
   }
}