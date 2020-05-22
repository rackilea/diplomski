@Aspect
public class MyAspect {
  @Around("call(* java.net.HttpURLConnection.connect()) && target(connection)")
  public Object onGetUrlConnection(ProceedingJoinPoint pjp, HttpURLConnection connection) throws Throwable {
    connection.setRequestProperty("From", "user@example.com");
    return pjp.proceed();
  }
}