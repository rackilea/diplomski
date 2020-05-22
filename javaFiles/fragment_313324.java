@Before("@annotation(com.company.annotation.AuthorizeUser")
public void isAuthorized(JoinPoint jp) {
    Class<?> returnType = ((MethodSignature)jp.getStaticPart()
            .getSignature()).getReturnType();
    if(returnType == String.class)
        ...
    else
        ...
}