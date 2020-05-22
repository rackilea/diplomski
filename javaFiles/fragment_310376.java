@Aspect
public class AbstractOrderAOP {

  // (...)

  @Pointcut(
    "execution(public * *..OrderThresholdDiscountPercentagePromotion.evaluate(..)) && " +
    "target(orderPromotion)"
  )
  public void evaluatePointcut(OrderPromotion orderPromotion) {}

  @Pointcut(
    "execution(protected * *..OrderPromotion.getOrderSubtotalAfterDiscounts(..)) && " +
    "args(ctx, order)"
  )
  public void subtotalPointcut(SessionContext ctx, AbstractOrder order) {}

  @Around("cflow(evaluatePointcut(orderPromotion)) && subtotalPointcut(ctx, order)")
  public Object getOrderSubtotalAfterDiscounts(
    ProceedingJoinPoint pjp,
    OrderPromotion orderPromotion,
    SessionContext ctx,
    AbstractOrder order
  ) {

    LOG.info("############ AbstractOrderAOP is being evaluated ############");
    try {
      final Object output = pjp.proceed();
    } catch (Throwable e) {
      e.printStackTrace();
    }

    ArrayList products = new ArrayList();

    // (...)

    return 0l;
  }

  // (...)
}