@Pointcut("within(@com.your.company.SomeAnnotationType *)")
public void methodsYouWantToAdvise() {};

@Aspect
public class AddToList {
@Around("methodsYouWantToAdvise()")
public Object addToList(ProceedingJoinPoint thisJoinPoint) throws Throwable {
    Object[] args = thisJoinPoint.getArgs();
    // you know the first parameter is the list you want to adjust
    List l = (List) args[0];
    l.add("new Value");

    thisJoinPoint.proceed(args);
}