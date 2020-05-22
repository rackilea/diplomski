public interface IUserService2 {

    Collection<User2> getUsers();

    User2 getUser(Integer id);

    Response add(User2 user);
}



public interface IUserService {

    List<User> getCurrentStatuses();

    void create(User user);

    List<User> getAllUsers();
}