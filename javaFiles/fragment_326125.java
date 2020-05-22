//Template generic class
public class GenericDAOAndModelClass<T> {
    public static List<T> getAll(String table) { your code};
    public static T getOne(String table) { your other code };

}

public class User extends GenericDAOAndModelClass<User> {
    user methods and fields

}