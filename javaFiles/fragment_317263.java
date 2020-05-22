/**
 * @ejb.bean
 * name="TimerBean"
 * jndi, home, remote config
 * @ejb.resource-ref
 *  res-ref-name="TimerController"
 *  res-type="commonj.timers.TimerManager"
 *  res-auth="Container"
 *  res-sharing-scope="Shareable"
 */
public abstract class TimerBean implements SessionBean {
  public void ejbCreate() {
    Context context = new InitialContext();
    TimerManager mgr = (TimerManager) context.lookup("java:comp/env/TimerController");
    // ...
  }
}