public class DateRealm extends JdbcRealm {

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {
    Date date = new Date();
    if ( /* Your dat condition here */ true) {
      return super.doGetAuthenticationInfo(token);
    } else {
      return null;
    }
  }
}