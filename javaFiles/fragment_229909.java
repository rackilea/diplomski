@Pointcut("execution(* aaa.bbb.ccc.ddd.*.*(..))")
public void methodInDddPackage() {}

@Pointcut("execution(* aaa.bbb.ccc.eee.*.*(..))")
public void methodInEeePackage() {}

@Pointcut("methodInDddPackage() || methodInEeePackage()")
public void methodInDddOrEeePackage() {}