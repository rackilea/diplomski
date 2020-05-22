@Before("@annotation(com.company.annotation.AuthorizeUser) && execution(String *.*(..))")
public void isAuthorizedString(JoinPoint jp) {
    ...
}

@Before("@annotation(com.company.annotation.AuthorizeUser) && execution(Response *.*(..))")
public void isAuthorizedResponse(JoinPoint jp) {
    ...
}