@Name("backingBean")
@Scope(ScopeType.CONVERSATION)
public class BackingBean {
  @In
  private FirstBean firstBean;

  @In
  private SecondBean secondBean;

  @In
  private ThirdBean thirdBean;

  public void performAction() {
    firstBean.performAction(secondBean, thirdBean);
  }
}