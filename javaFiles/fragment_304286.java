@OverrideStatementLocatorWith(SchemaReWriter.class)
public interface UserDao {

  @SqlQuery("select * from :schema.users")
  public List<User> getAllUsers();

}