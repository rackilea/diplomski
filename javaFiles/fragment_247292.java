/**
 * A custom runner for JUnit4.5 in which we demonstrate the interceptor pattern.
 * 
 * @version $Id: InterceptorRunner.java 201 2009-02-15 19:18:09Z paranoid12 $
 */
public class InterceptorRunner extends BlockJUnit4ClassRunner {
  /**
   * This is the InterceptorClasses annotation, which serves to hold our interceptor class
   * implementations.
   */
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  public @interface InterceptorClasses {

    /**
     * Value.
     * 
     * @return the classes to be run
     */
    public Class<?>[] value();
  }

  /**
   * This constructor is a must.
   * 
   * @param clazz the test-case class
   * @throws InitializationError the initialization error
   */
  public InterceptorRunner(Class<?> clazz) throws InitializationError {
    super(clazz);
  }

  /**
   * Override the methodInvoker, so that when it is called we wrap the statement with our own.
   * 
   * @param method the test method
   * @param test the test-case
   * @return the statement
   */
  @Override
  public Statement methodInvoker(FrameworkMethod method, Object test) {
    InterceptorStatement statement = new InterceptorStatement(super.methodInvoker(method, test));
    InterceptorClasses annotation = test.getClass().getAnnotation(InterceptorClasses.class);
    Class<?>[] klasez = annotation.value();
    try {
      for (Class<?> klaz : klasez) {

        statement.addInterceptor((Interceptor) klaz.newInstance());

      }
    } catch (IllegalAccessException ilex) {
      ilex.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    }
    return statement;
  }
}

/**
 * A statement for our custom runner.
 * 
 * @version $Id: InterceptorStatement.java 201 2009-02-15 19:18:09Z paranoid12 $
 */
public class InterceptorStatement extends Statement {
  /**
   * A wrapping invoker that will procede the execution, once we execute our interceptors.
   */
  private final Statement invoker;

  /**
   * A list of interceptors that will be executed before the other statements.
   */
  private List<Interceptor> interceptors = new ArrayList<Interceptor>();

  /**
   * A constructor that takes another invoker to wrap our statement.
   * 
   * @param invoker the invoker
   */
  public InterceptorStatement(Statement invoker) {
    this.invoker = invoker;
  }

  /**
   * We override this method to call our interceptors, and then evaluate the wrapping invoker.
   * 
   * @throws Throwable the throwable
   */
  @Override
  public void evaluate() throws Throwable {
    for (Interceptor interceptor : interceptors) {
      interceptor.interceptBefore();
    }

    invoker.evaluate();

    for (Interceptor interceptor : interceptors) {
      interceptor.interceptAfter();
    }
  }

  /**
   * Add another interceptor to the list of interceptors we have.
   * 
   * @param interceptor we want to add
   */
  public void addInterceptor(Interceptor interceptor) {
    interceptors.add(interceptor);
  }
}