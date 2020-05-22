import java.util.ArrayList;

public class Userlist
{

  private ArrayList<User> users; 

  public Userlist()
  {
    users = new ArrayList<User>();
  }

  public User findUser(String username)
  {
    for (User i : users)
    {
      if (i.userName.equals(username))
        return i;
    }
    return null;
  }

  public void addUser(User u)
  {
    if (findUser(u.userName) != null)
      System.out.println("User already exists");
    else
    {
     users.add(u); 
    }
  }
}