@Aspect
 @Component
 public class AspectTesting {
      @Pointcut("execution(* * (..))")
      public void allServices2() {
      }

      @Before("allServices2()")
      public void executee(JoinPoint joinPoint) {
          System.out.println("Advice woken" + joinPoint.getSignature().getName());
      }
}