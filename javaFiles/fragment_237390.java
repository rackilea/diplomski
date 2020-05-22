soemthing like this, 


public interface IUserDao {

    boolean create(User user);

    void saveOrUpdate(User user);

    boolean create(List<User> users);

    List<User> getAllUsers();

    User getById(int id);
}