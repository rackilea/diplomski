public class MethodInterceptor {

  private final ExpressionHandler expressionHandler;

  public MethodInterceptor(ExpressionHandler expressionHandler) {
    this.expressionHandler = expressionHandler;
  }

  @RuntimeType
  public Attribute intercept(@Origin Method method, @AllArguments Object[] args) throws Exception {       
    String name = method.getName();
    Class<? extends Attribute> type = (Class<? extends Attribute>) method.getReturnType();
    this.expressionHandler.attachStuff(name, type);
    return expressionHandler;
  }
}