public class ValidatingUserDB implements UserDB {
  private UserDB delegate;

  public ValidatingUserDB(UserDB delegate) {
    this.delegate = delegate;
  }

  public void addUser(User user) {
    User oldUser = delegate.get(user.getId());
    if (oldUser != null) throw new IllegalArgumentException(
             "User " + user.getId() + " already exists!";
    delegate.addUser(user);
  }
}