public class MyAction extends ActionSupport implements PrincipalAware {

  protected PrincipalProxy principal;

  public void setPrincipalProxy(PrincipalProxy principalProxy) {
    this.principal = principalProxy;
  }

  public PrincipalProxy getPrincipal() {
    return principal;
  }
}