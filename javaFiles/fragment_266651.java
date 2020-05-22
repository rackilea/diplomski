public class WrapperBeanImpl implements WrapperBean {

  private YourBean yb;

  private final Object lock;

  @Resource
  private SessionContext ctx;

  @PostConstruct
  public void init() {
    yb = ctx.getBusinessObject(YourBean.class);
  }

  @TransactionAttribute(TransactionAttributeType.NEVER)
  public void synchronizedDo() {
    synchronized(lock) {
      yb.do();
    }
  } 
}