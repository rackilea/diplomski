@Before("execution(* greeting(..)) && target(target) && " +
        "args(context)")
public void beforeReportGreeting(HelloIF target, Context context) {
       context.doSomething();
       target.doSomething();
}