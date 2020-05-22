@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@interface Catch{
  public Class<? extends ExceptionHandler> targetCatchHandler();
  public Class<? extends Throwable> targetException() default Exception.class;
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CatchGroup{
  public Catch[] catchers();
}