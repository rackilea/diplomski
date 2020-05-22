public abstract class Dao<T> {
    public T get(String id) { ... }

    ...
}

public class UserDao extends Dao<User> {
    ...
}

UserDao userDao = new UserDao();
User user = userDao.get(userId); //Returns a User