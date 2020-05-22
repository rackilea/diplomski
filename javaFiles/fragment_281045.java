// join points created by following point cuts
@Pointcut("within(@javax...XmlRootElement *)")
public void beanAnnotatedWithSpecificAnnotation()

@Pointcut("execution(* com.company.base..*(..))")
public void allMethods()

// this is advise
@Before("!beanAnnotatedWithSpecificAnnotation() && allMethods()")
public void applyAdvise(JoinPoint jp) {
// TODO: advise code ...
}