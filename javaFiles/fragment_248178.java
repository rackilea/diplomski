public class Login implements LoginMBean {
  private final String user;
  private final String password;

  public Login(String user, String password) {
    this.user = user;
    this.password = password;
  }

  @Override public String getName() { return user; }

  @Override public String getPassword() { return password; }
}