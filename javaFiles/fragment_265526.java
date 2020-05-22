public interface UserDAO 
    extends CrudRepository<User, Integer>, UserDAOCustom

public interface UserDAOCustom{
    public void customMethod();
}